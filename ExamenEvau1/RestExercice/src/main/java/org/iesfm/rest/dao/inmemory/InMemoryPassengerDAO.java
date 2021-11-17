package org.iesfm.rest.dao.inmemory;

import org.iesfm.rest.Passenger;
import org.iesfm.rest.dao.PassengerDAO;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InMemoryPassengerDAO implements PassengerDAO {
    private Map<String, Map<String, Passenger>> passengers = new HashMap<>();

    @Override
    public List<Passenger> getFlightPassengers(String flightNumber) {
        if (passengers.containsKey(flightNumber)) {
            return new LinkedList<>(passengers.get(flightNumber).values());
        } else {
            return new LinkedList<>();
        }
    }

    @Override
    public Passenger getFlightPassenger(String flightNumber, String nif) {
        if (passengers.containsKey(flightNumber)) {
            return passengers.get(flightNumber).get(nif);
        } else {
            return null;
        }
    }

    @Override
    public boolean addPassenger(String flightNumber, Passenger passenger) {
        if (passengers.containsKey(flightNumber)) {
            Map<String, Passenger> passengers = this.passengers.get(flightNumber);
            if (passengers.containsKey(passenger.getNif())) {
                return false;
            } else {
                passengers.put(passenger.getNif(), passenger);
                return true;
            }
        } else {
            Map<String, Passenger> passengers = new HashMap<>();
            passengers.put(passenger.getNif(), passenger);
            this.passengers.put(flightNumber, passengers);
            return true;
        }
    }

    @Override
    public boolean deletePassenger(String flightNumber, String nif) {
        if (passengers.containsKey(flightNumber)) {
            return passengers.get(flightNumber).remove(nif) != null;
        } else {
            return false;
        }
    }

    @Override
    public boolean updatePassenger(String flightNumber, Passenger passenger) {
        if (passengers.containsKey(flightNumber)) {
            if (passengers.get(flightNumber).containsKey(passenger.getNif())) {
                passengers.get(flightNumber).put(passenger.getNif(), passenger);
                return true;
            }
        }
        return false;

    }
}
