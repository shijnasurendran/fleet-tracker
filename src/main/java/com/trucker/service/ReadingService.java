package com.trucker.service;

import com.trucker.entity.Readings;

import java.util.List;

public interface ReadingService {

     List<Readings> findAllByVin(String vin);
    Readings create(Readings readings);
    List<Readings> findAll();

    List<Readings> findGeolocation(String vin);
}
