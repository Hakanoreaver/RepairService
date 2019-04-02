package com.CSCS314.RepairService.Repositories.Objects;

//import org.springframework.web.bind.annotations.CrossOrigins;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Professionals {
    //Initialise Variables

    //TODO Add the Location once format is decided
    @Id
    private int professionalId;
    private int avRating;
    private String name;
    private String bankToken;
    private String services;
    private String email;
    private String mobileNumber;
    private String passwordToken;
    private String ABN;
    private String certificationNumber;
    private Double priceVariance;

    //Getters
    public int getProfessionalId() {
        return professionalId;
    }
    public int getAvRating() {return avRating;}
    public String getName() {
        return name;
    }
    public String getBankToken() {
        return bankToken;
    }
    public String getServices() {
        return services;
    }
    public String getEmail() {
        return email;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public String getPasswordToken() {
        return passwordToken;
    }
    public String getABN() {
        return ABN;
    }
    public String getCertificationNumber() {
        return certificationNumber;
    }
    public Double getPriceVariance() {
        return priceVariance;
    }

    //Setters
    public void setProfessionalId(int CustomerId) {
        this.professionalId = CustomerId;
    }
    public void setAvRating(int AvRating) {
        this.avRating = AvRating;
    }
    public void setName(String Name) {
        this.name = Name;
    }
    public void setBankToken(String CardAuthToken) {
        this.bankToken = CardAuthToken;
    }
    public void setServices(String Vehicles) {
        this.services = Vehicles;
    }
    public void setEmail(String Email) {
        this.email = Email;
    }
    public void setMobileNumber(String MobileNumber) {
        this.mobileNumber = MobileNumber;
    }
    public void setPasswordToken(String PasswordToken) {
        this.passwordToken = PasswordToken;
    }
    public void setABN(String ABN) {
        this.ABN = ABN;
    }
    public void setCertificationNumber(String CertificationNumber) {
        this.certificationNumber = CertificationNumber;
    }
    public void setPriceVariance(Double PriceVariance) {
        this.priceVariance = PriceVariance;
    }
}