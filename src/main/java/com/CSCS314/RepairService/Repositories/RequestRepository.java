package com.CSCS314.RepairService.Repositories;

        import com.CSCS314.RepairService.Repositories.Objects.Professionals;
        import com.CSCS314.RepairService.Repositories.Objects.Requests;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository<Requests, Integer> {

    @Query("SELECT r FROM Requests r WHERE r.requestId = :requestId")
    public Requests findById(@Param("requestId") int requestId);

    @Query("SELECT max(r.requestId) FROM Requests r")
    public int findMax();
}

