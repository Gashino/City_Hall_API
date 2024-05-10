package cityHallAPI.dev.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Value;
@Entity
@Table(name = "users")
public class User {
    @Id
    private String dni;

    private String email;
    private String password;
    private boolean isActive;
    private boolean isAdmin;

    public User() {
    }

    public User(String dni, String email, String password) {
        this.dni = dni;
        this.email = email;
        this.password = password;
        this.isActive = true;
        this.isAdmin = false;
    }
    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
