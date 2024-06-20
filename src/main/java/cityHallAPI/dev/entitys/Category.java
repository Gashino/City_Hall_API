package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "rubros")
public class Category {

    @Id
    @Column(name = "idrubro")
    private int categoryId;

    @Column(name = "descripcion")
    private String description;

    public Category() {
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
