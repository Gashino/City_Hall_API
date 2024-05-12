package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "movimientosreclamo")
public class ClaimMovement {
    @Id
    @Column(name = "idMovimiento")
    private int idMovement;

    @ManyToOne
    @JoinColumn(name = "idReclamo")
    private Claim claim;

    @Column(name = "responsable")
    private String responsible;

    @Column(name = "causa")
    private String cause;

    @Column(name = "fecha")
    private Date date;

    public ClaimMovement() {
    }


}
