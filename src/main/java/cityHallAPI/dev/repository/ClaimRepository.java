package cityHallAPI.dev.repository;

import cityHallAPI.dev.entitys.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Integer>{
    @Query("SELECT c FROM Claim c INNER JOIN c.flaw f WHERE f.category.categoryId = :idCategory")
    List<Claim> findByCategoryId(int idCategory);
}
