package com.CSCS314.RepairService.Repositories;

import com.CSCS314.RepairService.Repositories.Objects.Customers;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Customers, String> {

}

