package com.trucker.service;

import com.trucker.entity.Alerts;
import com.trucker.entity.Tires;
import com.trucker.entity.Readings;
import com.trucker.entity.Vehicle;
import com.trucker.exception.BadRequestException;
import com.trucker.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService{

    @Autowired
    ReadingRepository repository;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    AlertsService alertsService;


    @Transactional
    public List<Readings> findAllByVin(String vin) {
      List<Readings> readings = repository.findAllByVin(vin);
      return  readings;
    }

    @Transactional
    public Readings create(Readings reading) {
        try {
            //List<Readings> readings = repository.findAllByVin(reading.getVin());
            Vehicle vehicle = vehicleService.findByVin(reading.getVin());
            checkAlerts(reading,vehicle);

        }catch (Exception e)
        {
            throw  new BadRequestException("The Readings data is not in a valid format");
        }
        return repository.save(reading);
    }

    @Transactional(readOnly = true)
    public List<Readings> findAll() {
        return (List<Readings>) repository.findAll();
    }

    @Override
    @Async
    public List<Readings> findGeolocation(String vin) {
        List<Readings> readings = (List<Readings>)repository.findAll();
        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(currentTimeStamp.getTime());
        cal.add(Calendar.MINUTE,-30);
        Timestamp lastRecentTime = new Timestamp(cal.getTime().getTime());

        List<Readings> vehicleGeoloc = new ArrayList<Readings>();
        for (Readings reading: readings)
        {
            if(reading.getVin().equals(vin))
            {
                if(currentTimeStamp.after(reading.getTimestamp())&&lastRecentTime.before(reading.getTimestamp()))
                {
                    vehicleGeoloc.add(reading);
                }

            }

        }
        return  vehicleGeoloc;
    }

    @Async
    void checkAlerts(Readings reading, Vehicle vehicle)
    {
            Tires tires = reading.getTires();
            if(reading.getEngineRpm() > vehicle.getRedlineRpm())
            {
                Alerts alert = new Alerts();
                alert.setVin(vehicle.getVin());
                alert.setTimestamp(reading.getTimestamp());
                alert.setAlertType("HighRPM");
                alert.setPriority("HIGH");
                alertsService.create(alert);
            }
            if (reading.getFuelVolume() < (0.1 * vehicle.getMaxFuelVolume())) {
                Alerts alert = new Alerts();
                alert.setVin(vehicle.getVin());
                alert.setTimestamp(reading.getTimestamp());
                alert.setAlertType("Low Fuel Volume");
                alert.setPriority("MEDIUM");
                alertsService.create(alert);
            }
            if (reading.getEngineCoolantLow() || reading.getCheckEngineLightOn()) {
                Alerts alert = new Alerts();
                alert.setVin(vehicle.getVin());
                alert.setTimestamp(reading.getTimestamp());
                alert.setAlertType("Either Engine Coolent is low or Engine Light is On");
                alert.setPriority("LOW");
                alertsService.create(alert);
            }
            if((tires.getFrontLeft()<32||tires.getFrontLeft()>36)||(tires.getFrontRight()<32||tires.getFrontRight()>36)
                    ||(tires.getRearLeft()<32||tires.getRearLeft()>36)||(tires.getRearRight()<32||tires.getRearRight()>36))
            {
                Alerts alert = new Alerts();
                alert.setVin(vehicle.getVin());
                alert.setTimestamp(reading.getTimestamp());
                alert.setAlertType("Tire Pressure Too Low or Too High");
                alert.setPriority("LOW");
                alertsService.create(alert);
            }

    }

}
