package com.trucker.controller;


import com.trucker.entity.Vehicle;
import com.trucker.service.VehicleService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/vehicles")
@Api(description = "Vehicle related endpoints")
public class VehicleController {
    @Autowired
    VehicleService service;



    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find All Vehicles",
            notes = "Returns a list of all vehicles available in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ModelAndView findAll() {
        ModelAndView mv=new ModelAndView();

        List<Vehicle> list=service.findAll();
        mv.addObject("vehicles", list);
        mv.setViewName("Vehicle");
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find Vehicle by Vin Number",
            notes = "Return a single vehicle or throws 404")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public Vehicle findOne(
            @ApiParam(value = "id of the Vehicle", required = true) @PathVariable("vin") String vin) {
        return service.findByVin(vin);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> create(@RequestBody List<Vehicle> vehicles) {

       // service.saveAll(vehicles);

        for(Vehicle vehicle :vehicles)
        {
             if(service.check(vehicle.getVin(),vehicle))
             {
                 System.out.println("Vehicle Service Updated");
                 service.update(vehicle.getVin(),vehicle);
             }
             else
             {
                 System.out.println("Vehicle Service Created");

                 service.create(vehicle);
             }


        }
        return vehicles;
    }


}
