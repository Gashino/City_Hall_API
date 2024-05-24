package cityHallAPI.dev.repository;

import cityHallAPI.dev.entitys.Complaint;
import cityHallAPI.dev.entitys.ComplaintIssuer;
import cityHallAPI.dev.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintIssuerRepository extends JpaRepository<ComplaintIssuer,Integer> {
    public List<Complaint> findByUser(User user);
}
