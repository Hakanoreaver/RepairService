package com.CSCS314.RepairService.Repositories.Objects;

//import org.springframework.web.bind.annotations.CrossOrigins;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Professionals {
    //Initialise Variables

    //TODO Add the Location once format is decided
    @Id
    private int ProfessionalId;
    private int AvRating;
    private String Name;
    private String BankToken;
    private String Services;
    private String Email;
    private String MobileNumber;
    private String PasswordToken;
    private String ABN;
    private String CertificationNumber;
    private Double PriceVariance;

    //Getters
    public int getProfessionalId() {
        return ProfessionalId;
    }
    public int getAvRating() {return AvRating;}
    public String getName() {
        return Name;
    }
    public String getBankToken() {
        return BankToken;
    }
    public String getServices() {
        return Services;
    }
    public String getEmail() {
        return Email;
    }
    public String getMobileNumber() {
        return MobileNumber;
    }
    public String getPasswordToken() {
        return PasswordToken;
    }
    public String getABN() {
        return ABN;
    }
    public String getCertificationNumber() {
        return CertificationNumber;
    }
    public Double getPriceVariance() {
        return PriceVariance;
    }

    //Setters
    public void setProfessionalId(int CustomerId) {
        this.ProfessionalId = CustomerId;
    }
    public void setAvRating(int AvRating) {
        this.AvRating = AvRating;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setBankToken(String CardAuthToken) {
        this.BankToken = CardAuthToken;
    }
    public void setServices(String Vehicles) {
        this.Services = Vehicles;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public void setMobileNumber(String MobileNumber) {
        this.MobileNumber = MobileNumber;
    }
    public void setPasswordToken(String PasswordToken) {
        this.PasswordToken = PasswordToken;
    }
    public void setABN(String ABN) {
        this.ABN = ABN;
    }
    public void setCertificationNumber(String CertificationNumber) {
        this.CertificationNumber = CertificationNumber;
    }
    public void setPriceVariance(Double PriceVariance) {
        this.PriceVariance = PriceVariance;
    }
}