package com.trucker.service;


import com.trucker.repository.VehicleRepository;
import com.trucker.entity.Vehicle;
import com.trucker.exception.BadRequestException;
import com.trucker.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;

    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return (List<Vehicle>) repository.findAll();
    }

    @Transactional(readOnly = true)
    public Vehicle findOne(String id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Vehicle with id " + id + " doesn't exist."));
    }

    @Transactional
    public Vehicle create(Vehicle vehicle) {
        Optional<Vehicle> existing = repository.findByVin(vehicle.getVin());
        if (existing.isPresent()) {
            throw new BadRequestException("Vehicle with Vin " + vehicle.getVin() + " already exists.");
        }
        return repository.save(vehicle);
    }

    @Transactional
    public Vehicle update(String vin, Vehicle vehicle) {
        Optional<Vehicle> existing = repository.findByVin(vin);
        repository.delete(existing.get());
        Optional<Vehicle> checked = repository.findByVin(vin);
        if (!checked.isPresent()) {
            System.out.println("Repository saved-updated the data");
             repository.save(vehicle);
        }
       return  vehicle;
    }



    @Transactional
    public void delete(String vin) {
        Optional<Vehicle> existing = repository.findByVin(vin);
        if (!existing.isPresent()) {
            throw new ResourceNotFoundException("Employee with id " + vin + " doesn't exist.");
        }
        repository.delete(existing.get());

    }

    public  Boolean check(String vin,Vehicle vehicle)
    {
        Optional<Vehicle> exists = repository.findByVin(vehicle.getVin());
        if(exists.isPresent())
        {
            return true;
        }
        else
        {
            return  false;
        }
    }

    @Transactional
    public List<Vehicle> saveAll(List<Vehicle> vehicles)
    {
       return (List<Vehicle>) repository.saveAll( vehicles);
    }


    @Transactional(readOnly = true)
    public Vehicle findByVin(String vin) {
        return repository.findByVin(vin)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Vehicle with vin " + vin + " doesn't exist."));
    }
}
