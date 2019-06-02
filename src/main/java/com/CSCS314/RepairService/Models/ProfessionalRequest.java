package com.CSCS314.RepairService.Models;

public class ProfessionalRequest {
    double averageNum;
    int numProfessionals;
    double averageEarnt;

    public ProfessionalRequest() {

    }

    public ProfessionalRequest(double averageNum, int numProfessionals, double averageEarnt) {
        this.averageNum = averageNum;
        this.numProfessionals = numProfessionals;
        this.averageEarnt = averageEarnt;
    }

    public double getAverageNum() {
        return averageNum;
    }

    public void setAverageNum(double averageNum) {
        this.averageNum = averageNum;
    }

    public int getNumProfessionals() {
        return numProfessionals;
    }

    public void setNumProfessionals(int numProfessionals) {
        this.numProfessionals = numProfessionals;
    }

    public double getAverageEarnt() {
        return averageEarnt;
    }

    public void setAverageEarnt(double averageEarnt) {
        this.averageEarnt = averageEarnt;
    }
}
