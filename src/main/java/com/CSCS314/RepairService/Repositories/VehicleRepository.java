package com.CSCS314.RepairService.Repositories;

import com.CSCS314.RepairService.Repositories.Objects.Customers;
import com.CSCS314.RepairService.Repositories.Objects.Requests;
import com.CSCS314.RepairService.Repositories.Objects.Vehicles;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicles, String> {
    @Query("SELECT v FROM Vehicles v WHERE v.VehicleId = :vehicleId")
    public Vehicles findById(@Param("vehicleId") int vehicleId);

    @Query("SELECT v FROM Vehicles v WHERE v.userId = :userId")
    public List<Vehicles> findByUserId(@Param("userId") int userId);

    @Modifying
    @Transactional
    @Query("UPDATE Vehicles v SET Year = :year WHERE v.VehicleId = :vehicleId")
    public void updateYear(@Param("year") int year,@Param("vehicleId") int vehicleId);

    @Modifying
    @Transactional
    @Query("UPDATE Vehicles v SET MakeModel = :MakeModel WHERE v.VehicleId = :vehicleId")
    public void updateMakeModel(@Param("MakeModel") String MakeModel,@Param("vehicleId") int vehicleId);

    @Modifying
    @Transactional
    @Query("UPDATE Vehicles v SET NumberPlate = :NumberPlate WHERE v.VehicleId = :vehicleId")
    public void updateNumberPlate(@Param("NumberPlate") String NumberPlate,@Param("vehicleId") int vehicleId);

}

