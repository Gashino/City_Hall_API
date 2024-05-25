package cityHallAPI.dev.entitys;

import cityHallAPI.dev.utill.Status;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "reclamos")
public class Claim {

    @Id
    @Column(name = "id_reclamo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClaim;

    @ManyToOne
    @JoinColumn(name = "documento")
    private User user;

    @ManyToOne
    @JoinColumn(name = "legajo")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_sitio")
    private Site site;

    @ManyToOne
    @JoinColumn(name = "id_desperfecto")
    private Flaw flaw;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "estado")
    private String status;

    @Column(name = "idReclamoUnificado")
    private int idUnifiedClaim;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "claim")
    private List<ClaimMovement> movements;


    public Claim(User user, Employee employee, Site site, Flaw flaw ,
                 String description, String status) {
        this.flaw = flaw;
        this.user = user;
        this.employee = employee;
        this.site = site;
        this.description = description;
        this.status = status;
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
}
