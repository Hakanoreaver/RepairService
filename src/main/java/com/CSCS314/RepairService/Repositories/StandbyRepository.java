package com.CSCS314.RepairService.Repositories;

import com.CSCS314.RepairService.Repositories.Objects.Requests;
import com.CSCS314.RepairService.Repositories.Objects.StandbyRequests;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StandbyRepository extends CrudRepository<StandbyRequests, Integer> {

    @Query("SELECT r FROM StandbyRequests r WHERE r.requestId = :requestId")
    public StandbyRequests findById(@Param("requestId") int requestId);

    @Modifying
    @Transactional
    @Query("UPDATE StandbyRequests p SET Duration = :duration WHERE p.requestId = :requestId")
    public void updateDuration(@Param("duration") long duration,@Param("requestId") Integer requestId);
}

