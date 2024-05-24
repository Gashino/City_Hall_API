package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "denunciaemisor")
public class ComplaintIssuer {

    @Id
    @Basic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "dni")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idDenuncias")
    private Complaint complaint;


    public ComplaintIssuer() {
    }


    public ComplaintIssuer(User user, Complaint complaint) {
        this.user = user;
        this.complaint = complaint;
    }


}
