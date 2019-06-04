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

    @Modifying
    @Transactional
    @Query("UPDATE Professionals p SET avRating = :avRating WHERE p.professionalId = :professionalId")
    public void updateRating(@Param("avRating") double avRating,@Param("professionalId") Integer professionalId);

    @Modifying
    @Transactional
    @Query("UPDATE Professionals p SET name = :name WHERE p.professionalId = :professionalId")
    public void updateName(@Param("name") String name,@Param("professionalId") Integer professionalId);

    @Modifying
    @Transactional
    @Query("UPDATE Professionals p SET bankToken = :bankToken WHERE p.professionalId = :professionalId")
    public void updateBankToken(@Param("bankToken") String bankToken,@Param("professionalId") Integer professionalId);

    @Modifying
    @Transactional
    @Query("UPDATE Professionals p SET email = :email WHERE p.professionalId = :professionalId")
    public void updateEmail(@Param("email") String email,@Param("professionalId") Integer professionalId);

    @Modifying
    @Transactional
    @Query("UPDATE Professionals p SET mobileNumber = :mobileNumber WHERE p.professionalId = :professionalId")
    public void updateMobile(@Param("mobileNumber") String mobileNumber,@Param("professionalId") Integer professionalId);

    @Modifying
    @Transactional
    @Query("UPDATE Professionals p SET passwordToken = :passwordToken WHERE p.professionalId = :professionalId")
    public void updatePassword(@Param("passwordToken") String passwordToken,@Param("professionalId") Integer professionalId);

    @Modifying
    @Transactional
    @Query("UPDATE Professionals p SET ABN = :ABN WHERE p.professionalId = :professionalId")
    public void updateABN(@Param("ABN") String ABN,@Param("professionalId") Integer professionalId);

    @Modifying
    @Transactional
    @Query("UPDATE Professionals p SET certificationNumber = :certificationNumber WHERE p.professionalId = :professionalId")
    public void updateCertification(@Param("certificationNumber") String certificationNumber,@Param("professionalId") Integer professionalId);

    @Modifying
    @Transactional
    @Query("UPDATE Professionals p SET priceVariance = :priceVariance WHERE p.professionalId = :professionalId")
    public void updatePrice(@Param("priceVariance") double priceVariance,@Param("professionalId") Integer professionalId);

}

