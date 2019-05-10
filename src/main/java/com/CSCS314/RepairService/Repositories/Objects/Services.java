package com.CSCS314.RepairService.Repositories.Objects;

//import org.springframework.web.bind.annotations.CrossOrigins;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class Services {

    //Initialise Variables
    //TODO add Location

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", updatable = false, nullable = false)
    int Id;
    String Name;
    Double Cost;

    //Getters
    public int getId() {
        return Id;
    }
    public String getName() {
        return Name;
    }
    public Double getCost() {
        return Cost;
    }

    //Setters
    public void setId(int id) {
        Id = id;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setCost(Double cost) {
        Cost = cost;
    }
}