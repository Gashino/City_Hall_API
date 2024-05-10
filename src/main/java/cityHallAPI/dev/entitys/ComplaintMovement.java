package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "movimientosdenuncia")
public class ComplaintMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Complaint complaint; // TODO
    private User responsible; // TODO
    private String cause;
    private Date date;

    public ComplaintMovement() {
    }

    public ComplaintMovement(Complaint complaint, User responsible, String cause) {
        this.complaint = complaint;
        this.responsible = responsible;
        this.cause = cause;
        this.date = new Date();
    }


}
