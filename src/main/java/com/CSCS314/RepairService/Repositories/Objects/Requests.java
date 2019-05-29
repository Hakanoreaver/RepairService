package com.CSCS314.RepairService.Repositories.Objects;

//import org.springframework.web.bind.annotations.CrossOrigins;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class Requests {

    public Requests() {

    }


    //Initialise Variables
    //TODO add Location
    @Id
    int requestId;
    int CustomerId;
    int ProfessionalId;
    boolean Accepted;
    int Problem;
    int VehicleId;
    long Duration;
    Date RequestDate;
    boolean isFinished;
    String professionalIds;
    double longitude;
    double latitude;

    //Getters
    public int getRequestId() {
        return requestId;
    }
    public int getCustomerId() {
        return CustomerId;
    }
    public int getProfessionalId() {
        return ProfessionalId;
    }
    public boolean isAccepted() {
        return Accepted;
    }
    public int getProblem() {
        return Problem;
    }
    public int getVehicleId() {
        return VehicleId;
    }
    public long getDuration() {
        return Duration;
    }
    public Date getRequestDate() {
        return RequestDate;
    }
    public boolean getisFinished() {
        return isFinished;
    }

    //Setters
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }
    public void setProfessionalId(int professionalId) {
        ProfessionalId = professionalId;
    }
    public void setAccepted(boolean accepted) {
        Accepted = accepted;
    }
    public void setProblem(int problem) {
        Problem = problem;
    }
    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }
    public void setDuration(long duration) {
        Duration = duration;
    }
    public void setRequestDate(Date requestDate) {
        RequestDate = requestDate;
    }
    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public String getProfessionalIds() {
        return professionalIds;
    }

    public void setProfessionalIds(String professionalIds) {
        this.professionalIds = professionalIds;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}