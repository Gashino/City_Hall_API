package cityHallAPI.dev.repository;

import cityHallAPI.dev.entitys.Complaint;
import cityHallAPI.dev.entitys.Neighbor;
import cityHallAPI.dev.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ComplaintRepository extends JpaRepository<Complaint,Integer> {
    @Query("SELECT c FROM Complaint c " +
            "LEFT JOIN ComplaintIssuer ci ON c.idComplaint = ci.complaint.idComplaint " +
            "WHERE ci.user.document = :document OR c.user.document = :document")
    public List<Complaint> findByDocument(@Param("document") String document);
}
