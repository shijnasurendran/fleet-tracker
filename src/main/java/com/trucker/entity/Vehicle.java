package com.trucker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/*
========================== SAMPLE DATA =======================================
[
 {
    "vin": "1HGCR2F3XFA027534",
    "make": "HONDA",
    "model": "ACCORD",
    "year": 2015,
    "redlineRpm": 5500,
    "maxFuelVolume": 15,
    "lastServiceDate": "2017-05-25T17:31:25.268Z"
 },
 {
    "vin": "WP1AB29P63LA60179",
    "make": "PORSCHE",
    "model": "CAYENNE",
    "year": 2015,
    "redlineRpm": 8000,
    "maxFuelVolume": 18,
    "lastServiceDate": "2017-03-25T17:31:25.268Z"
 }
]


*/
@Entity
public class Vehicle {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(unique = true)
    private String vin;

    private String make,model;
    private int year,redlineRpm,maxFuelVolume;
    private Timestamp lastServiceDate;

    public Vehicle()
    {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Timestamp lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    @Override
    public String toString()
    {
        return "Vehicle{"+"id:"+id+'\''
                +"vin:"+vin+'\''
                +"Make:"+make+'\''
                +"Model:"+model+'\''
                +"Year:"+year+'\''
                +"RedLineRPM:"+redlineRpm+'\''
                +"MaxFuelVolume:"+maxFuelVolume+'\''
                +"LastServiceDate"+lastServiceDate.toString()
                ;
    }
}
