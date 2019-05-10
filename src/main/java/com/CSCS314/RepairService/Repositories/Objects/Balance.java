package com.CSCS314.RepairService.Repositories.Objects;

import javax.persistence.*;

@Entity
public class Balance {
    //Initialse variables
    @Id
    private int balanceId;
    double balance;

    //Getters

    public int getAdminId() {
        return balanceId;
    }

    public double getPasswordToken() {
        return balance;
    }

    //Setters

    public void setAdminId(int adminId) {
        this.balanceId = adminId;
    }

    public void setPasswordToken(double passwordToken) {
        this.balance = passwordToken;
    }
}
