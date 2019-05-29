package com.CSCS314.RepairService.Repositories.Objects;

//import org.springframework.web.bind.annotations.CrossOrigins;

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
    Double amount;
    String status;
    Date date;

    //Getters
    public int getTransactionalId() {
        return TransactionalId;
    }
    public int getRequestId() {
        return RequestId;
    }
    public Double getAmount() {
        return amount;
    }
    public String getStatus() {
        return status;
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
        this.amount = amount;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}