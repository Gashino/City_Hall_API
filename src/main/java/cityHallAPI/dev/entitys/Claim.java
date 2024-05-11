package cityHallAPI.dev.entitys;

import cityHallAPI.dev.utill.Status;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "reclamos")
public class Claim {

    @Id
    @Column(name = "idReclamo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClaim;

    @ManyToOne
    @JoinColumn(name = "documento")
    private User user;

    @ManyToOne
    @JoinColumn(name = "legajo")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "idSitio")
    private Site site;

    @ManyToOne
    @JoinColumn(name = "idDesperfecto")
    private Flaw flaw;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "estado")
    private String status;

    @Column(name = "idReclamoUnificado")
    private int idUnifiedClaim;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "claim")
    private List<ClaimMovement> movements;

    public Claim(){}
}
