package com.CSCS314.RepairService.Repositories.Objects;

//import org.springframework.web.bind.annotations.CrossOrigins;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Requests {
    //Initialise Variables
    //TODO add Location
    @Id
    int RequestId;
    int CustomerId;
    int ProfessionalId;
    boolean Accepted;
    int Problem;
    int VehicleId;
    int Duration;
    Date RequestDate;

    //Getters
    public int getRequestId() {
        return RequestId;
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
    public int getDuration() {
        return Duration;
    }
    public Date getRequestDate() {
        return RequestDate;
    }

    //Setters
    public void setRequestId(int requestId) {
        RequestId = requestId;
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
    public void setDuration(int duration) {
        Duration = duration;
    }
    public void setRequestDate(Date requestDate) {
        RequestDate = requestDate;
    }

}