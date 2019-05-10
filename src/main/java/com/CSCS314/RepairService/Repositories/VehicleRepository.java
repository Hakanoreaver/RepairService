package com.CSCS314.RepairService.Repositories;

import com.CSCS314.RepairService.Repositories.Objects.Customers;
import com.CSCS314.RepairService.Repositories.Objects.Requests;
import com.CSCS314.RepairService.Repositories.Objects.Vehicles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicles, String> {

    @Query("SELECT v FROM Vehicles v WHERE v.userId = :userId")
    public List<Vehicles> findById(@Param("userId") int userId);
}

