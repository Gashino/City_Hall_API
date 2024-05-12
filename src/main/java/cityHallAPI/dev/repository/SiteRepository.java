package cityHallAPI.dev.repository;

import cityHallAPI.dev.entitys.Site;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository extends JpaRepository<Site,Integer> {
}
