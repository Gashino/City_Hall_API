package cityHallAPI.dev.repository;

import cityHallAPI.dev.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    public Optional<User> findByEmailAndPassword(String mail, String password);

    public Optional<User> findByEmail(String mail);
}
