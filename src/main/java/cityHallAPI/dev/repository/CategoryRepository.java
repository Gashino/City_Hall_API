package cityHallAPI.dev.repository;

import cityHallAPI.dev.entitys.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
