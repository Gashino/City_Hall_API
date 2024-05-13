package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "servicios")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idServicio")
    private int idService;

    @Column(name = "documento")
    private String document;

    @Column(name = "titulo")
    private String title;

    @Column(name = "descripcion")
    private String description;

    @Basic
    private boolean isActive;

    @Basic
    private boolean isProfesional;

    public Service(){}

    public Service(String document, String title, String description) {
        this.document = document;
        this.title = title;
        this.description = description;
        this.isActive = false;
        this.isProfesional = false;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isProfesional() {
        return isProfesional;
    }

    public void setProfesional(boolean profesional) {
        isProfesional = profesional;
    }
}
