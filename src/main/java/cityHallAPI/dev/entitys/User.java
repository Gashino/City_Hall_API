package cityHallAPI.dev.entitys;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;
@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @Column(name = "dni")
    private String document;

    @Column(name = "mail")
    private String email;

    @Basic
    private String password;

    @Column(name = "isactive")
    private boolean isActive;

    @Basic
    private String expoPushToken;

    public User() {
    }

    public User(String document, String email, String password, String expoPushToken) {
        this.document = document;
        this.email = email;
        this.password = password;
        this.isActive = true;
        this.expoPushToken = expoPushToken;
    }


    public String getExpoPushToken() {
        return expoPushToken;
    }

    public void setExpoPushToken(String expoPushToken) {
        this.expoPushToken = expoPushToken;
    }

    public String getDocument() {
        return document;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
