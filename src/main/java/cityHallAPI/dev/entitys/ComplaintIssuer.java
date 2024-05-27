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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iddenuncias")
    private Complaint complaint;


    public ComplaintIssuer() {
    }


    public ComplaintIssuer(User user, Complaint complaint) {
        this.user = user;
        this.complaint = complaint;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
}
