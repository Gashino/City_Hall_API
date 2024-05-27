package cityHallAPI.dev.entitys;

import cityHallAPI.dev.utill.Status;
import jakarta.persistence.*;

import javax.naming.Name;
import java.util.List;

@Entity
@Table(name = "denuncias")
public class Complaint {

    @Id
    @Column(name = "iddenuncias")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComplaint;

    @ManyToOne
    @JoinColumn(name = "documento")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idsitio")
    private Site site;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "estado")
    private String status;

    @Column(name = "aceptaresponsabilidad")
    private boolean responsability;


    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "complaint")
    private List<ComplaintMovement> movements;

    public Complaint() {
    }

    public Complaint(User user, Site site, String description) {
        this.user = user;
        this.site = site;
        this.description = description;
        this.status = Status.PENDIENTE.toString();
        this.responsability = true;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    @Override
    public String toString() {
        return "Complaint{" +
                "idComplaint=" + idComplaint +
                ", user=" + user +
                ", site=" + site +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", responsability=" + responsability +
                ", movements=" + movements +
                '}';
    }
}
