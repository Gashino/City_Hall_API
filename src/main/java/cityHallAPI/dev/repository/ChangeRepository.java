package cityHallAPI.dev.repository;

import cityHallAPI.dev.entitys.Change;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChangeRepository extends JpaRepository<Change, Integer>{
    @Query("SELECT c FROM Change c WHERE c.notified = false")
    List<Change> findAllUnnotifiedChanges();
}
