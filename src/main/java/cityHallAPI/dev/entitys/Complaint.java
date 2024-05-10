package cityHallAPI.dev.entitys;

import cityHallAPI.dev.utill.Status;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    private Site site;
    private String description;
    private Status status;
    private boolean responsability;

    public Complaint() {
    }

    public Complaint(String description, String dni, Site site) {
        this.description = description;
        this.dni = dni;
        this.site = site;
        this.status = Status.PENDIENTE;
        this.responsability = true;
    }

    public Complaint(Long id, String dni, Site site, String description, Status status) {
        this.id = id;
        this.dni = dni;
        this.site = site;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDni() {
        return dni;
    }

    public Site getSite() {
        return site;
    }

    public Status getStatus() {
        return status;
    }

    public boolean getResponsability() {
        return responsability;
    }
}
