package com.CSCS314.RepairService.Repositories.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
    //Initialse variables
    @Id
    int adminId;
    String passwordToken;

    //Getters

    public int getAdminId() {
        return adminId;
    }

    public String getPasswordToken() {
        return passwordToken;
    }

    //Setters

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public void setPasswordToken(String passwordToken) {
        this.passwordToken = passwordToken;
    }
}
