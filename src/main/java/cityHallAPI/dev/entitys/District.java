package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "barrios")
public class District {

    @Id
    @Column(name = "idbarrio")
    private int idDistrict;

    @Column(name = "nombre")
    private String name;

    public District() {

    }

    public District(int idDistrict, String name) {
        this.idDistrict = idDistrict;
        this.name = name;
    }
}
