package cityHallAPI.dev.repository;

import cityHallAPI.dev.entitys.Neighbor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NeighborRepository extends JpaRepository<Neighbor,String> {
}
