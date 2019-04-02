package com.CSCS314.RepairService.Repositories;

import com.CSCS314.RepairService.Repositories.Objects.Customers;
import com.CSCS314.RepairService.Repositories.Objects.Professionals;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProfessionalRepository extends CrudRepository<Professionals, String> {
    @Query("SELECT p FROM Professionals p WHERE p.email = :email")
    public Professionals findByEmail(@Param("email") String email);

    @Query("SELECT p FROM Professionals p WHERE p.professionalId = :professionalId")
    public Professionals findById(@Param("professionalId") int professionalId);
}

