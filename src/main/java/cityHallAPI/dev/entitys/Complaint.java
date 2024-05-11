package cityHallAPI.dev.entitys;

import cityHallAPI.dev.utill.Status;
import jakarta.persistence.*;

import javax.naming.Name;
import java.util.List;

@Entity
@Table(name = "denuncias")
public class Complaint {

    @Id
    @Column(name = "idDenuncias")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComplaint;

    @ManyToOne
    @JoinColumn(name = "documento")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idSitio")
    private Site site;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "estado")
    private Status status;

    @Column(name = "aceptaResponsabilidad")
    private boolean responsability;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "complaint")
    private List<ComplaintMovement> movements;

    public Complaint() {
    }


}
