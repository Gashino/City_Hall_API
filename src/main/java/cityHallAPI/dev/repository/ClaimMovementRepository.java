package cityHallAPI.dev.repository;

import cityHallAPI.dev.entitys.ClaimMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimMovementRepository extends JpaRepository<ClaimMovement,Integer> {
}
