package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "barrio")
public class District {

    @Id
    @Column(name = "idBarrio")
    private int idDistrict;

    @Column(name = "nombre")
    private String name;
    public District() {

    }

}
