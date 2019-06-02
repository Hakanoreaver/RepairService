package com.CSCS314.RepairService.Models;

public class TakingsRequest {
    double totalIncoming;
    double totalOutgoing;
    double profit;
    double averageIncoming;
    double averageOutgoing;
    double highestIncoming;
    double lowestIncoming;
    double highestOutgoing;
    double lowestOutgoing;

    public double getTotalIncoming() {
        return totalIncoming;
    }

    public void setTotalIncoming(double totalIncoming) {
        this.totalIncoming = totalIncoming;
    }

    public double getTotalOutgoing() {
        return totalOutgoing;
    }

    public void setTotalOutgoing(double totalOutgoing) {
        this.totalOutgoing = totalOutgoing;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getAverageIncoming() {
        return averageIncoming;
    }

    public void setAverageIncoming(double average) {
        this.averageIncoming = average;
    }

    public double getAverageOutgoing() {
        return averageIncoming;
    }

    public void setAverageOutgoing(double average) {
        this.averageOutgoing = average;
    }

    public double getHighestIncoming() {
        return averageOutgoing;
    }

    public void setHighestIncoming(double highestIncoming) {
        this.highestIncoming = highestIncoming;
    }

    public double getLowestIncoming() {
        return lowestIncoming;
    }

    public void setLowestIncoming(double lowestIncoming) {
        this.lowestIncoming = lowestIncoming;
    }

    public double getHighestOutgoing() {
        return highestOutgoing;
    }

    public void setHighestOutgoing(double highestOutgoing) {
        this.highestOutgoing = highestOutgoing;
    }

    public double getLowestOutgoing() {
        return lowestOutgoing;
    }

    public void setLowestOutgoing(double lowestOutgoing) {
        this.lowestOutgoing = lowestOutgoing;
    }
}
