package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "rubro")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String description;

    public Category() {
    }

    public Category(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
