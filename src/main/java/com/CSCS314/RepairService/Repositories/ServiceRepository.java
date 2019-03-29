package com.CSCS314.RepairService.Repositories;

import com.CSCS314.RepairService.Repositories.Objects.Customers;
import com.CSCS314.RepairService.Repositories.Objects.Services;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Services, String> {

}

