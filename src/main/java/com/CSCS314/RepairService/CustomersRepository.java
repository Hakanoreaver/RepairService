package com.CSCS314.RepairService;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.CSCS314.RepairService.Customer;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Date;

public interface CustomersRepository extends CrudRepository<Customer, String> {

}
