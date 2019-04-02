package com.CSCS314.RepairService.Repositories;

        import com.CSCS314.RepairService.Repositories.Objects.Customers;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends CrudRepository<Customers, Integer> {
        @Query("SELECT c FROM Customers c WHERE c.Email = :Email")
        public Customers findByEmail(@Param("Email") String Email);

        @Query("SELECT c FROM Customers c WHERE c.customerId = :customerId")
        public Customers findById(@Param("customerId") int customerId);
}
