package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "barrio")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    public District(String name) {
        this.name = name;
    }
    public District(Long id) {
        this.id = id;
    }

    public District() {

    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

}
