package com.CSCS314.RepairService.Repositories;

import com.CSCS314.RepairService.Repositories.Objects.Customers;
import com.CSCS314.RepairService.Repositories.Objects.Reviews;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Reviews, String> {

}
