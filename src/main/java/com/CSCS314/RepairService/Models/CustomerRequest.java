package com.CSCS314.RepairService.Models;

public class CustomerRequest {
    double averageNumRequests;
    int numCustomers;
    int numLoyaltyCustomers;
    int numNotLoyaltyCustomers;
    double averageSpent;

    public double getAverageNumRequests() {
        return averageNumRequests;
    }

    public void setAverageNumRequests(double averageNumRequests) {
        this.averageNumRequests = averageNumRequests;
    }

    public int getNumCustomers() {
        return numCustomers;
    }

    public void setNumCustomers(int numCustomers) {
        this.numCustomers = numCustomers;
    }

    public int getNumLoyaltyCustomers() {
        return numLoyaltyCustomers;
    }

    public void setNumLoyaltyCustomers(int numLoyaltyCustomers) {
        this.numLoyaltyCustomers = numLoyaltyCustomers;
    }

    public int getNumNotLoyaltyCustomers() {
        return numNotLoyaltyCustomers;
    }

    public void setNumNotLoyaltyCustomers(int numNotLoyaltyCustomers) {
        this.numNotLoyaltyCustomers = numNotLoyaltyCustomers;
    }

    public double getAverageSpent() {
        return averageSpent;
    }

    public void setAverageSpent(double averageSpent) {
        this.averageSpent = averageSpent;
    }
}
