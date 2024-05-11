package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "rubros")
public class Category {

    @Id
    @Column(name = "idRubro")
    private int categoryId;

    @Column(name = "descripcion")
    private String description;

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }
}
