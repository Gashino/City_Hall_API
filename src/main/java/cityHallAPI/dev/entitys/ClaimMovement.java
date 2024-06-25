package cityHallAPI.dev.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Claim claim;

    @Column(name = "responsable")
    private String responsible;

    @Column(name = "causa")
    private String cause;

    @Column(name = "fecha")
    private Date date;

    public ClaimMovement() {
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(int idMovement) {
        this.idMovement = idMovement;
    }

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
