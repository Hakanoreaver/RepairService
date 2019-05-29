package com.CSCS314.RepairService.Repositories;

import com.CSCS314.RepairService.Repositories.Objects.Customers;
import com.CSCS314.RepairService.Repositories.Objects.Professionals;
import com.CSCS314.RepairService.Repositories.Objects.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transactions, String> {
    @Query("SELECT avg(amount) FROM Transactions t WHERE t.date between :startDate and :endDate and t.status = :status")
    public Double averageBetweenDates(@Param("status") String status, @Param("startDate")Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT sum(amount) FROM Transactions t WHERE t.date between :startDate and :endDate and t.status = :status")
    public Double sumBetweenDates(@Param("status") String status, @Param("startDate")Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT sum(amount) FROM Transactions t WHERE t.date between :startDate and :endDate and t.status = :status")
    public Double highestBetweenDates(@Param("status") String status, @Param("startDate")Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT sum(amount) FROM Transactions t WHERE t.date between :startDate and :endDate and t.status = :status")
    public Double lowestBetweenDate(@Param("status") String status, @Param("startDate")Date startDate, @Param("endDate") Date endDate);
}

