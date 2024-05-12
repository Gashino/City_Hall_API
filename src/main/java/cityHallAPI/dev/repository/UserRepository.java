package cityHallAPI.dev.repository;

import cityHallAPI.dev.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
