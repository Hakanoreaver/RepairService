package com.CSCS314.RepairService.Repositories.Objects;

import javax.persistence.*;

@Entity
public class Admin {
    //Initialse variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adminId", updatable = false, nullable = false)
    private int adminId;
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
