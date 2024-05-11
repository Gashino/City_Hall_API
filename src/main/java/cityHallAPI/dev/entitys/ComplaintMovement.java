package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movimientosdenuncia")
public class ComplaintMovement {
    @Id
    @Column(name = "idDenuncia")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idDenuncias")
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
