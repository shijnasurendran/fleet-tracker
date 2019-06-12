package com.trucker.service;

import com.trucker.entity.Alerts;

import java.util.List;

public interface AlertsService {
    List<Alerts> findAllByVin(String vin);
    Alerts create(Alerts alert);
    List<Alerts> findAll();

    List<Alerts> findRecentAlerts();

    List<Alerts> findHistoricalAlerts(String vin);

}
