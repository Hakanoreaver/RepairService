package com.CSCS314.RepairService.Models;

public class HalfModel {
    double total;
    double average;
    double highest;
    double lowest;

    public HalfModel(double total, double average, double highest, double lowest) {
        this.total = total;
        this.average = average;
        this.highest = highest;
        this.lowest = lowest;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getHighest() {
        return highest;
    }

    public void setHighest(double highest) {
        this.highest = highest;
    }

    public double getLowest() {
        return lowest;
    }

    public void setLowest(double lowest) {
        this.lowest = lowest;
    }
}
