package com.trucker.controller;


import com.trucker.entity.Alerts;
import com.trucker.entity.Vehicle;
import com.trucker.service.AlertsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/alerts")
@Api(description = "Reading related endpoints")
public class AlertsController
{

    @Autowired
    AlertsService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find All Alerts",
            notes = "Returns a list of all alerts available in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ModelAndView findAll() {
        ModelAndView mv=new ModelAndView();

        List<Alerts> list=service.findAll();
        mv.addObject("alerts", list);
        mv.setViewName("Alert");
        return mv;
        //return service.findAll();
    }


    @RequestMapping(value = "/recent",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find recent Alerts",
            notes = "Returns a list of all alerts available in the database for last 2 hours")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ModelAndView findRecentAlerts() {
        ModelAndView mv=new ModelAndView();

        List<Alerts> list=service.findRecentAlerts();
        mv.addObject("alerts", list);
        mv.setViewName("Alert");
        return mv;
    }





    @RequestMapping(method = RequestMethod.GET, value = "/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find Vehicle Historical Alerts by Vin Number",
            notes = "Return Vehicle Historical Alerts by Vin Number")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ModelAndView findHistoricalAlerts( @ApiParam(value = "vin of the Vehicle", required = true) @PathVariable("vin") String vin) {
        ModelAndView mv=new ModelAndView();

        List<Alerts> list=service.findHistoricalAlerts(vin);
        mv.addObject("alerts", list);
        mv.setViewName("Alert");
        return mv;
    }



}
