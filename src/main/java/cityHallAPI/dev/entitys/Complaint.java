package cityHallAPI.dev.entitys;

import cityHallAPI.dev.utill.Status;
import jakarta.persistence.*;

import javax.naming.Name;
import java.util.List;

@Entity
@Table(name = "denuncias")
public class Complaint {

    @Id
    @Column(name = "idDenuncias")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComplaint;

    @ManyToOne
    @JoinColumn(name = "documento")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idSitio")
    private Site site;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "estado")
    private Status status;

    @Column(name = "aceptaResponsabilidad")
    private boolean responsability;

    @ManyToOne
    @JoinColumn(name = "dni")
    private User denounced;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "complaint")
    private List<ComplaintMovement> movements;

    public Complaint() {
    }

    public Complaint(User user, Site site, String description, User denounced) {
        this.user = user;
        this.site = site;
        this.description = description;
        this.status = Status.PENDIENTE;
        this.denounced = denounced;
        this.responsability = true;
    }

    public User getDenounced() {
        return denounced;
    }

    public void setDenounced(User denounced) {
        this.denounced = denounced;
    }

    public int getIdComplaint() {
        return idComplaint;
    }

    public void setIdComplaint(int idComplaint) {
        this.idComplaint = idComplaint;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isResponsability() {
        return responsability;
    }

    public void setResponsability(boolean responsability) {
        this.responsability = responsability;
    }

    public List<ComplaintMovement> getMovements() {
        return movements;
    }

    public void setMovements(List<ComplaintMovement> movements) {
        this.movements = movements;
    }
}
