package com.CSCS314.RepairService.Repositories;

import com.CSCS314.RepairService.Repositories.Objects.Admin;
import com.CSCS314.RepairService.Repositories.Objects.Customers;
import com.CSCS314.RepairService.Repositories.Objects.Requests;
import com.CSCS314.RepairService.Repositories.Objects.Reviews;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Reviews, String> {
    @Query("SELECT r FROM Reviews r WHERE r.ProfessionalId = :ProfessionalId")
    public List<Reviews> findById(@Param("ProfessionalId") int ProfessionalId);

    @Query("SELECT r FROM Reviews r WHERE r.ReviewId = :reviewId")
    public Reviews find(@Param("reviewId") int reviewId);

    @Modifying
    @Transactional
    @Query("UPDATE Reviews r SET TextString = :textString WHERE r.ReviewId = :reviewId")
    public void updateText(@Param("textString") String textString,@Param("reviewId") int reviewId);

    @Modifying
    @Transactional
    @Query("UPDATE Reviews r SET rating = :rating WHERE r.ReviewId = :reviewId")
    public void updateRating(@Param("rating") double rating,@Param("reviewId") int reviewId);


}
