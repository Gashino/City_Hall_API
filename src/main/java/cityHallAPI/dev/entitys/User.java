package cityHallAPI.dev.entitys;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;
@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @Column(name = "dni")
    private String document;
    @Basic
    private String email;
    @Basic
    private String password;
    @Basic
    private boolean isActive;
    @Basic
    private boolean isAdmin;

    public User() {
    }

    public User(String document, String email, String password) {
        this.document = document;
        this.email = email;
        this.password = password;
        this.isActive = true;
        this.isAdmin = false;
    }
    public String getDni() {
        return document;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
