package cityHallAPI.dev.repository;

import cityHallAPI.dev.entitys.Complaint;
import cityHallAPI.dev.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComplaintRepository extends JpaRepository<Complaint,Integer> {
    public List<Complaint> findByUser(User user);
    public List<Complaint> findByDenounced(User user);
}
