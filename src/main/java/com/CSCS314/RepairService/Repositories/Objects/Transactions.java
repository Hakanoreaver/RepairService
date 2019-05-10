package com.CSCS314.RepairService.Repositories.Objects;

//import org.springframework.web.bind.annotations.CrossOrigins;
import org.springframework.ui.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Transactions {
    //Initialise Variables
    //TODO add Location

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionalId", updatable = false, nullable = false)
    int TransactionalId;
    int RequestId;
    Double Amount;
    String Status;
    Date date;

    //Getters
    public int getTransactionalId() {
        return TransactionalId;
    }
    public int getRequestId() {
        return RequestId;
    }
    public Double getAmount() {
        return Amount;
    }
    public String getStatus() {
        return Status;
    }
    public Date getDate() {
        return date;
    }

    //Setters
    public void setTransactionalId(int transactionalId) {
        TransactionalId = transactionalId;
    }
    public void setRequestId(int requestId) {
        RequestId = requestId;
    }
    public void setAmount(Double amount) {
        Amount = amount;
    }
    public void setStatus(String status) {
        Status = status;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}