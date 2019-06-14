package com.trucker.controller;

import com.trucker.entity.Readings;
import com.trucker.entity.Vehicle;
import com.trucker.service.ReadingService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/readings")
@Api(description = "Reading related endpoints")
public class ReadingsController {

    @Autowired
    ReadingService service;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings create(@RequestBody Readings reading) {
        return service.create(reading);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find Readings by Car Vin",
            notes = "Return a List of Readings")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ModelAndView findAllByVin(
            @ApiParam(value = "Vin of the Car", required = true) @PathVariable("vin") String vin) {
        ModelAndView mv=new ModelAndView();

        List<Readings> list=service.findAllByVin(vin);
        mv.addObject("reading", list);
        mv.setViewName("Reading");
        return mv;
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find All Readings",
            notes = "Returns a list of all Readings available in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ModelAndView findAll() {
        ModelAndView mv=new ModelAndView();

        List<Readings> list=service.findAll();
        mv.addObject("reading", list);
        mv.setViewName("Reading");
        return mv;
    }





    @RequestMapping(method = RequestMethod.GET, value = "/geo/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find Vehicle GeoLocation by Vin Number",
            notes = "Return a single vehicle or throws 404")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Readings> findGeolocation(@ApiParam(value = "vin of the Vehicle", required = true) @PathVariable("vin") String vin) {
        return service.findGeolocation(vin);
    }

}
