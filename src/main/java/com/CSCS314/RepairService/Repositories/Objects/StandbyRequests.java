package com.CSCS314.RepairService.Repositories.Objects;

//import org.springframework.web.bind.annotations.CrossOrigins;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class StandbyRequests {

    public StandbyRequests() {

    }
    public StandbyRequests(Requests r) {
        setRequestId(r.getRequestId());
        setCustomerId(r.getCustomerId());
        setProfessionalId(r.getProfessionalId());
        setAccepted(r.Accepted);
        setProblem(r.getProblem());
        setVehicleId(r.getVehicleId());
        setDuration(r.getDuration());
    }
    //Initialise Variables
    //TODO add Location
    @Id
    int requestId;
    int CustomerId;
    int ProfessionalId;
    boolean Accepted = false;
    int Problem;
    int VehicleId;
    long Duration;
    Date RequestDate;
    boolean isFinished = false;

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

}