package com.CSCS314.RepairService.Repositories;

        import com.CSCS314.RepairService.Repositories.Objects.Professionals;
        import com.CSCS314.RepairService.Repositories.Objects.Requests;
        import org.springframework.data.jpa.repository.Modifying;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;
        import org.springframework.transaction.annotation.Transactional;

        import java.sql.Date;
        import java.util.List;

@Repository
public interface RequestRepository extends CrudRepository<Requests, Integer> {

    @Query("SELECT r FROM Requests r WHERE r.requestId = :requestId")
    public Requests findById(@Param("requestId") int requestId);

    @Query("SELECT max(r.requestId) FROM Requests r")
    public int findMax();

    @Query("SELECT count(t) from Requests t")
    int getAmounts();

    @Query("SELECT r FROM Requests r WHERE r.RequestDate < :date and r.Accepted = false or r.isFinished = false")
    public List<Requests> findProblems(@Param("date") Date date);

    @Modifying
    @Transactional
    @Query("UPDATE Requests r SET r.professionalIds = :professionalIds WHERE r.requestId = :requestId")
    public void updateProfessionals(@Param("requestId") int requestId,@Param("professionalIds") String professionalIds);

    @Modifying
    @Transactional
    @Query("UPDATE Requests p SET Duration = :duration WHERE p.requestId = :requestId")
    public void updateDuration(@Param("duration") long duration,@Param("requestId") Integer requestId);

    @Modifying
    @Transactional
    @Query("UPDATE Requests p SET p.isFinished = :finished WHERE p.requestId = :requestId")
    public void updateFinished(@Param("finished") boolean finished,@Param("requestId") Integer requestId);

    @Modifying
    @Transactional
    @Query("UPDATE Requests p SET p.Accepted = :finished WHERE p.requestId = :requestId")
    public void updateAccepted(@Param("finished") boolean finished,@Param("requestId") Integer requestId);

    @Modifying
    @Transactional
    @Query("UPDATE Requests p SET p.ProfessionalId = :professionalId WHERE p.requestId = :requestId")
    public void updateProfessional(@Param("professionalId") int professionalId,@Param("requestId") Integer requestId);
}

