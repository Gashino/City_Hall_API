package cityHallAPI.dev.entitys;


import jakarta.persistence.*;

@Entity
@Table(name = "desperfectos")
public class Flaw {

    @Id
    @Column(name = "idDesperfecto")
    private int flawId;

    @Column(name = "descripcion")
    private String description;

    @ManyToOne
    @JoinColumn(name = "idRubro")
    private Category category;

    public Flaw(){
    }

}
