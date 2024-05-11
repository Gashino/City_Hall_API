package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "barrio")
public class District {
    @Id
    private int id;

    @Column(name = "nombre")
    private String name;
    public District() {

    }

}
