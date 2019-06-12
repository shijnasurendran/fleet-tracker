package com.trucker.service;

import com.trucker.entity.Alerts;
import com.trucker.repository.AlertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class AlertsServiceImpl implements AlertsService {

    @Autowired
    AlertsRepository repository;

    @Transactional
    public Alerts create(Alerts alert) {
        return repository.save(alert);
    }

    @Transactional
    public List<Alerts> findAll()
    {
     return (List<Alerts>)repository.findAll();
    }

    @Override
    public List<Alerts> findRecentAlerts() {
        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(currentTimeStamp.getTime());
        cal.add(Calendar.HOUR_OF_DAY,-2);
        Timestamp lastRecentTime = new Timestamp(cal.getTime().getTime());
        List<Alerts> alerts = (List<Alerts>)repository.findAll();
        List<Alerts> recentAlerts = new ArrayList<Alerts>();
        for (Alerts alert: alerts)
        {
            if(currentTimeStamp.after(alert.getTimestamp())&&lastRecentTime.before(alert.getTimestamp()))
            {
                recentAlerts.add(alert);
            }
        }
        return recentAlerts;
    }

    @Override
    @Async
    public List<Alerts> findHistoricalAlerts(String vin) {
        List<Alerts> alerts = (List<Alerts>)repository.findAll();
        List<Alerts> historicalAlerts = new ArrayList<Alerts>();
        for (Alerts alert: alerts)
        {
            if(alert.getVin().equals(vin))
            {
                historicalAlerts.add(alert);
            }

        }
        return  historicalAlerts;
    }

    @Transactional
    public List<Alerts> findAllByVin(String vin)
    {
        return (List<Alerts>)repository.findAllByVin(vin);
    }

}
