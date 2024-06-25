package cityHallAPI.dev.entitys;

import cityHallAPI.dev.utill.Status;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "reclamos")
public class Claim {

    @Id
    @Column(name = "idreclamo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClaim;

    @ManyToOne
    @JoinColumn(name = "documento")
    private User user;

    @ManyToOne
    @JoinColumn(name = "legajo")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "idsitio")
    private Site site;

    @ManyToOne
    @JoinColumn(name = "iddesperfecto")
    private Flaw flaw;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "estado")
    private String status;

    @Column(name = "idreclamounificado")
    private int idUnifiedClaim;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "claim")
    @JsonManagedReference
    private List<ClaimMovement> movements;

    @ElementCollection
    @CollectionTable(
            name = "imagenesreclamos",
            joinColumns = @JoinColumn(name = "idreclamo")
    )
    @Column(name = "nombrearchivo")
    private List<String> images;


    public Claim(User user, Employee employee, Site site, Flaw flaw ,
                 String description,List<String> images) {
        this.flaw = flaw;
        this.user = user;
        this.employee = employee;
        this.site = site;
        this.description = description;
        this.status = Status.EN_PROCESO.toString();
        this.images = images;
    }

    public Claim(){}

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getIdClaim() {
        return idClaim;
    }

    public void setIdClaim(int idClaim) {
        this.idClaim = idClaim;
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

    public Flaw getFlaw() {
        return flaw;
    }

    public void setFlaw(Flaw flaw) {
        this.flaw = flaw;
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

    public int getIdUnifiedClaim() {
        return idUnifiedClaim;
    }

    public void setIdUnifiedClaim(int idUnifiedClaim) {
        this.idUnifiedClaim = idUnifiedClaim;
    }

    public List<ClaimMovement> getMovements() {
        return movements;
    }

    public void setMovements(List<ClaimMovement> movements) {
        this.movements = movements;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
