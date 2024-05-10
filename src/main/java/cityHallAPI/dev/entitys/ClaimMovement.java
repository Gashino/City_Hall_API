package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "movimientosreclamo")
public class ClaimMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Claim claim; // TODO
    private User responsible; // TODO
    private String cause;
    private Date date;

    public ClaimMovement() {
    }

    public ClaimMovement(Claim claim, User responsible, String cause) {
        this.claim = claim;
        this.responsible = responsible;
        this.cause = cause;
        this.date = new Date();
    }
}
