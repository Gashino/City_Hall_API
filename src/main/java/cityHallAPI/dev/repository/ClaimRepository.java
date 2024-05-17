package cityHallAPI.dev.repository;

import cityHallAPI.dev.entitys.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Integer>{
}
