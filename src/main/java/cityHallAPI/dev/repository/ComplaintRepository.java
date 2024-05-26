package cityHallAPI.dev.repository;

import cityHallAPI.dev.entitys.Complaint;
import cityHallAPI.dev.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ComplaintRepository extends JpaRepository<Complaint,Integer> {
    @Query("SELECT c FROM Complaint c INNER JOIN ComplaintIssuer ci ON c.idComplaint = ci.complaint.idComplaint WHERE ci.user = :user OR c.user = :user")
    public List<Complaint> findByUser(User user);
}
