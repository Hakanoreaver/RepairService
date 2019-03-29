package com.CSCS314.RepairService.Repositories;

import com.CSCS314.RepairService.Repositories.Objects.Customers;
import com.CSCS314.RepairService.Repositories.Objects.Professionals;
import org.springframework.data.repository.CrudRepository;

public interface ProfessionalRepository extends CrudRepository<Professionals, String> {

}

