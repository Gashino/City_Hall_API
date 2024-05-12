package cityHallAPI.dev.repository;

import cityHallAPI.dev.entitys.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint,Integer> {
}
