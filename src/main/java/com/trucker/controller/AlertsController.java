package com.trucker.controller;


import com.trucker.entity.Alerts;
import com.trucker.service.AlertsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "Find All Employee",
            notes = "Returns a list of all employees avaialble in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Alerts> findAll() {
        return service.findAll();
    }


    @RequestMapping(value = "/recent",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find All Alerts",
            notes = "Returns a list of all alerts avaialble in the database for last 2 hours")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Alerts> findRecentAlerts() {
        return service.findRecentAlerts();
    }





    @RequestMapping(method = RequestMethod.GET, value = "/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find Vehicle Historical Alerts by Vin Number",
            notes = "Return a single vehicle or throws 404")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Alerts> findHistoricalAlerts( @ApiParam(value = "vin of the Vehicle", required = true) @PathVariable("vin") String vin) {
        return service.findHistoricalAlerts(vin);
    }



}
