package com.CSCS314.RepairService.Repositories;

        import com.CSCS314.RepairService.Repositories.Objects.Customers;
        import org.springframework.data.jpa.repository.Modifying;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;
        import org.springframework.transaction.annotation.Transactional;

        import java.sql.Date;

@Repository
public interface CustomersRepository extends CrudRepository<Customers, Integer> {
        @Query("SELECT c FROM Customers c WHERE c.Email = :Email")
        public Customers findByEmail(@Param("Email") String Email);

        @Query("SELECT c FROM Customers c WHERE c.customerId = :customerId")
        public Customers findById(@Param("customerId") int customerId);

        @Query("SELECT count(c) FROM Customers c")
        public int findTotal();

        @Query("SELECT count(c) FROM Customers c where c.CustomerType = true")
        public int findTotalLoyalty();

        @Modifying
        @Transactional
        @Query("UPDATE Customers c SET Name = :Name WHERE c.customerId = :customerId")
        public void updateName(@Param("Name") String Name,@Param("customerId") Integer customerId);

        @Modifying
        @Transactional
        @Query("UPDATE Customers c SET CardAuthToken = :CardAuthToken WHERE c.customerId = :customerId")
        public void updateCardAuthToken(@Param("CardAuthToken") String CardAuthToken,@Param("customerId") Integer customerId);

        @Modifying
        @Transactional
        @Query("UPDATE Customers c SET MobileNumber = :MobileNumber WHERE c.customerId = :customerId")
        public void updateMobileNumber(@Param("MobileNumber") String MobileNumber,@Param("customerId") Integer customerId);

        @Modifying
        @Transactional
        @Query("UPDATE Customers c SET PasswordToken = :PasswordToken WHERE c.customerId = :customerId")
        public void updatePassword(@Param("PasswordToken") String PasswordToken,@Param("customerId") Integer customerId);

        @Modifying
        @Transactional
        @Query("UPDATE Customers c SET CustomerType = :subscription WHERE c.customerId = :customerId")
        public void updateSubscription(@Param("subscription") boolean subscription,@Param("customerId") Integer customerId);

        @Modifying
        @Transactional
        @Query("UPDATE Customers c SET SubscriptionDate = :subDate WHERE c.customerId = :customerId")
        public void updateSubDate(@Param("subDate") Date subDate, @Param("customerId") Integer customerId);
}
