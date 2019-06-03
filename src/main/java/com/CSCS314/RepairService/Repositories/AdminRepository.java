package com.CSCS314.RepairService.Repositories;

import com.CSCS314.RepairService.Repositories.Objects.Admin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
    @Query("SELECT a FROM Admin a WHERE a.adminId = :adminId")
    public Admin findById(@Param("adminId") int adminId);

    @Modifying
    @Transactional
    @Query("UPDATE Admin a SET passwordToken = :PasswordToken WHERE a.adminId = :adminId")
    public void updatePassword(@Param("PasswordToken") String PasswordToken,@Param("adminId") int adminId);
}
