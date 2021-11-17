package org.iesfm.rest.controllers;

import org.iesfm.rest.Flight;
import org.iesfm.rest.dao.FlightDAO;
import org.iesfm.rest.exceptions.FlightNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;


@RestController
public class ControllerFlightDAO {

    private FlightDAO flightDAO;

    public ControllerFlightDAO(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/flights")
    public List<Flight> list() {
        return flightDAO.list();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/flights/{flightNumber}")
    public void getFlight(@PathVariable("flightNumber") String flightNumber) {
        try {
            flightDAO.getFlight(flightNumber);
        } catch (FlightNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ERROR 404, Not found"
            );
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/flights")
    public void addFlight(@RequestBody Flight newFlight) {

        if (!flightDAO.addFlight(newFlight)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "ERROR 409, Ya existe el vuelo"
            );
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/flights/{flightNumber}")
    public void deleteFlight(@PathVariable("flightNumber") String flightNumber) {
        try {
            flightDAO.deleteFlight(flightNumber);
        } catch (FlightNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ERROR 404, Not found"
            );
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/flights/{flightNumber}")
    public void update(@RequestBody Flight updateFlight){
        try {
            flightDAO.updateFlight(updateFlight);
        } catch (FlightNotFoundException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ERROR 404, Not found"
            );
        }

    }
}
