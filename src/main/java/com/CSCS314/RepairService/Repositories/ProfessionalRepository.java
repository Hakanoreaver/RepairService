package com.CSCS314.RepairService.Repositories;

import com.CSCS314.RepairService.Repositories.Objects.Customers;
import com.CSCS314.RepairService.Repositories.Objects.Professionals;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Repository
public interface ProfessionalRepository extends CrudRepository<Professionals, Integer> {
    @Query("SELECT p FROM Professionals p WHERE p.email = :email")
    public Professionals findByEmail(@Param("email") String email);

    @Query("SELECT p FROM Professionals p WHERE p.professionalId = :professionalId")
    public Professionals findById(@Param("professionalId") int professionalId);

    @Query("SELECT count(p) FROM Professionals p")
    public int findTotal();

    @Modifying
    @Transactional
    @Query("UPDATE Professionals p SET requestId = :requestId WHERE p.professionalId = :professionalId")
    public void updateRequest(@Param("requestId") int requestId,@Param("professionalId") Integer professionalId);

}

