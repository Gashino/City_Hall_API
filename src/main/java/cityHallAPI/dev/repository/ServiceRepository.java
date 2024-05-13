package cityHallAPI.dev.repository;


import cityHallAPI.dev.entitys.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Integer>{

}