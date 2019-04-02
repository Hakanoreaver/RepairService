package com.CSCS314.RepairService.Repositories.Objects;

//import org.springframework.web.bind.annotations.CrossOrigins;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Customers {
	//Initialise Variables
	@Id
	private int customerId;
	private boolean CustomerType;
	private String Name;
	private String CardAuthToken;
	private String Vehicles;
	private Date SubscriptionDate;
	private String Email;
	private String MobileNumber;
	private String PasswordToken;

	//Getters
	public int getCustomerId() {
		return customerId;
	}
	public boolean getCustomerType() {
		return CustomerType;
	}
	public String getName() {
		return Name;
	}
	public String getCardAuthToken() {
		return CardAuthToken;
	}
	public String getVehicles() {
		return Vehicles;
	}
	public Date getSubscriptionDate() {
		return SubscriptionDate;
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

	//Setters
	public void setCustomerId(int CustomerId) {
		this.customerId = CustomerId;
	}
	public void setCustomerType(boolean CustomerType) {
		this.CustomerType = CustomerType;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public void setCardAuthToken(String CardAuthToken) {
		this.CardAuthToken = CardAuthToken;
	}
	public void setVehicles(String Vehicles) {
		this.Vehicles = Vehicles;
	}
	public void setSubscriptionDate(Date SubscriptionDate) {
		this.SubscriptionDate = SubscriptionDate;
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
}