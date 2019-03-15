package com.CSCS314.RepairService.Repositories.Objects;

//import org.springframework.web.bind.annotations.CrossOrigins;
import org.springframework.ui.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Reviews {
    //Initialise Variables
    //TODO add Location

    @Id
    int ReviewId;
    int CustomerId;
    String TextString;
    int Rating;
    int ProfessionalId;

    //Getters
    public int getReviewId() {
        return ReviewId;
    }
    public int getCustomerId() {
        return CustomerId;
    }
    public String getTextString() {
        return TextString;
    }
    public int getRating() {
        return Rating;
    }
    public int getProfessionalId() {
        return ProfessionalId;
    }

    //Setters
    public void setReviewId(int reviewId) {
        ReviewId = reviewId;
    }
    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }
    public void setTextString(String textString) {
        TextString = textString;
    }
    public void setRating(int rating) {
        Rating = rating;
    }
    public void setProfessionalId(int professionalId) {
        ProfessionalId = professionalId;
    }
}
