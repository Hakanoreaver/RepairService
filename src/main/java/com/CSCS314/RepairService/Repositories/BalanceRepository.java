package com.CSCS314.RepairService.Repositories;

import com.CSCS314.RepairService.Repositories.Objects.Balance;
import com.CSCS314.RepairService.Repositories.Objects.Customers;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BalanceRepository extends CrudRepository<Balance, Integer> {
    @Query("SELECT b FROM Balance b WHERE b.balanceId = 1")
    public double getBalance();

    @Modifying
    @Transactional
    @Query("UPDATE Balance b SET b.balance = :balance WHERE b.balanceId = 1")
    public void updateBalance(@Param("balance") double balance);
}
