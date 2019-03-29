package com.CSCS314.RepairService.Repositories;

import com.CSCS314.RepairService.Repositories.Objects.Customers;
import com.CSCS314.RepairService.Repositories.Objects.Transactions;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transactions, String> {

}

