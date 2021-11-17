package org.iesfm.rest.controllers;


import org.iesfm.rest.Flight;
import org.iesfm.rest.Passenger;
import org.iesfm.rest.dao.FlightDAO;
import org.iesfm.rest.dao.PassengerDAO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ControllerPassengerDAO {

    private PassengerDAO passengerDAO;

    public ControllerPassengerDAO(PassengerDAO passengerDAO) {
        this.passengerDAO = passengerDAO;

    }

    @RequestMapping(method = RequestMethod.GET, path = "/flights/{flightNumber}/passengers")
    public List<Passenger> list(@PathVariable("flightNumber") String flightNumber) {
        if (flightNumber == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ERROR 404, pasajerp no encontrado"
            );
        } else {
            return passengerDAO.getFlightPassengers(flightNumber);
        }

    }

    @RequestMapping(method = RequestMethod.GET, path = "/flights/{flightNumber}/passengers/{nif}")
    public Passenger getPassenger(@PathVariable("flightNumber") String flightNumber, @PathVariable("nif") String nif) {
        if (flightNumber == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ERROR 404, pasajero no encontrado"
            );
        } else {
            return passengerDAO.getFlightPassenger(flightNumber, nif);
        }

    }

    @RequestMapping(method = RequestMethod.POST, path = "/flights/{flightNumber}/passengers")
    public void addPassenger(@PathVariable("flightNumber") String flightNumber, @RequestBody Passenger passenger) {
       if (!passengerDAO.addPassenger(flightNumber, passenger)){
           throw new ResponseStatusException(
                   HttpStatus.CONFLICT, "ERROR 409, pasajero ya existe"
           );
       }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/flights/{flightNumber}/passengers/{nif}")
    public void deletePassenger(@PathVariable("flightNumber") String flightNumber, @PathVariable("nif") String nif) {

        if (!passengerDAO.deletePassenger(flightNumber, nif)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ERROR 404, pasajero no existe"
            );
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/flights/{flightNumber}/passengers")
    public void updatePassenger(@PathVariable("flightNumber") String flightNumber, @RequestBody Passenger passenger) {
        if (!passengerDAO.updatePassenger(flightNumber, passenger)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ERROR 404, pasajero no existe"
            );
        }
    }
}
