package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movimientosdenuncia")
public class ComplaintMovement {
    @Id
    @Column(name = "idmovimiento")
    private int idMovement;

    @ManyToOne
    @JoinColumn(name = "iddenuncias")
    private Complaint complaint;

    @Column(name = "responsable")
    private String responsible;

    @Column(name = "causa")
    private String cause;

    @Column(name = "fecha")
    private Date date;


    public ComplaintMovement() {
    }



}
