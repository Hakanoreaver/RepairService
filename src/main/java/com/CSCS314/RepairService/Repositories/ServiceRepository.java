package com.CSCS314.RepairService.Repositories;

import com.CSCS314.RepairService.Repositories.Objects.Customers;
import com.CSCS314.RepairService.Repositories.Objects.Requests;
import com.CSCS314.RepairService.Repositories.Objects.Services;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ServiceRepository extends CrudRepository<Services, Integer> {
    @Query("SELECT s FROM Services s WHERE s.id = :id")
    public Services findById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE Services s SET Name = :Name WHERE s.Id = :Id")
    public void updateName(@Param("Name") String Name,@Param("Id") int Id);

    @Modifying
    @Transactional
    @Query("UPDATE Services s SET Cost = :Cost WHERE s.Id = :Id")
    public void updateCost(@Param("Cost") double Cost,@Param("Id") int Id);



}

