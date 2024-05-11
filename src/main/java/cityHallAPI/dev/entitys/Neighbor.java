package cityHallAPI.dev.entitys;
import jakarta.persistence.*;


@Entity
@Table(name = "vecinos")
public class Neighbor {

    @Id
    @Column(name = "documento")
    private String document;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String surname;

    @Column(name = "direccion")
    private String adress;

    @ManyToOne
    @JoinColumn(name = "codigobarrio")
    private District district;

    public Neighbor(){}

}
