package com.trucker.repository;

import com.trucker.entity.Alerts;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlertsRepository extends CrudRepository<Alerts,String> {

    List<Alerts> findAllByVin(String vin);
}
