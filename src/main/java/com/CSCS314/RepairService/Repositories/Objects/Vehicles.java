package com.CSCS314.RepairService.Repositories.Objects;

//import org.springframework.web.bind.annotations.CrossOrigins;
import org.springframework.ui.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Vehicles {
    //Initialise Variables
    //TODO add Location
    @Id
    int VehicleId;
    String NumberPlate;
    String MakeModel;
    int Year;

    //Getters

    public int getVehicleId() {
        return VehicleId;
    }
    public String getNumberPlate() {
        return NumberPlate;
    }
    public String getMakeModel() {
        return MakeModel;
    }
    public int getYear() {
        return Year;
    }

    //Setters
    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }
    public void setNumberPlate(String numberPlate) {
        NumberPlate = numberPlate;
    }
    public void setMakeModel(String makeModel) {
        MakeModel = makeModel;
    }
    public void setYear(int year) {
        Year = year;
    }
}