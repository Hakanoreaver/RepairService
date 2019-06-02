package com.CSCS314.RepairService.Repositories;

import com.CSCS314.RepairService.Models.HalfModel;
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
    @Query("SELECT new com.CSCS314.RepairService.Models.HalfModel(avg(amount), sum(amount), max(amount), min(amount)) FROM Transactions t WHERE t.date between :startDate and :endDate and t.status = :status")
    public HalfModel calcBetweenDates(@Param("status") String status, @Param("startDate")Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT count(t) FROM Transactions t WHERE t.date between :startDate and :endDate and t.status = :status")
    public int calcAmountBetweenDates(@Param("status") String status, @Param("startDate")Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT count(t) FROM Transactions t WHERE t.date between :startDate and :endDate and t.status = :status")
    public int calcTotalBetweenDates(@Param("status") String status, @Param("startDate")Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT count(t) from Transactions t where t.status = :status group by t.personId")
    int[]  getAverage(@Param("status") String status);

    @Query("SELECT sum(amount) from Transactions t where t.status = :status")
    double  getTotal(@Param("status") String status);

    @Query("SELECT sum(amount) from Transactions t")
    double  getGrandTotal();

}

