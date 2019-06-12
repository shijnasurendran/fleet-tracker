package com.trucker.repository;

import com.trucker.entity.Readings;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReadingRepository extends CrudRepository<Readings,String> {
    List<Readings> findAllByVin(String vin);
}
