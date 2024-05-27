package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "movimientosreclamo")
public class ClaimMovement {
    @Id
    @Column(name = "idmovimiento")
    private int idMovement;

    @ManyToOne
    @JoinColumn(name = "idreclamo")
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
