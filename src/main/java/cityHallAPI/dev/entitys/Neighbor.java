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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
