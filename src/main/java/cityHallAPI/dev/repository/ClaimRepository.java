package cityHallAPI.dev.repository;

import cityHallAPI.dev.entitys.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Integer>{
    @Query("SELECT c FROM Claim c INNER JOIN c.flaw f WHERE f.category.categoryId = :idCategory")
    List<Claim> findByCategoryId(int idCategory);

    @Query(value = "SELECT " +
            "r.idReclamo, " +
            "r.descripcion, " +
            "r.idReclamoUnificado, " +
            "CASE " +
            "    WHEN r.idReclamoUnificado = 0 THEN r.estado " +
            "    ELSE (SELECT ru.estado FROM reclamos ru WHERE ru.idReclamo = r.idReclamoUnificado) " +
            "END AS estado, " +
            "r.legajo, " +
            "r.idDesperfecto, " +
            "r.idSitio, " +
            "r.documento " +
            "FROM reclamos r",
            nativeQuery = true)
    List<Claim> findAllReclamos();

}
