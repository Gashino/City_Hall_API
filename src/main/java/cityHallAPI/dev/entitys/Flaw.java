package cityHallAPI.dev.entitys;


import jakarta.persistence.*;

@Entity
@Table(name = "desperfectos")
public class Flaw {

    @Id
    @Column(name = "iddesperfecto")
    private int idFlaw;

    @Column(name = "descripcion")
    private String description;

    @ManyToOne
    @JoinColumn(name = "idrubro")
    private Category category;

    public Flaw(){
    }

    public int getIdFlaw() {
        return idFlaw;
    }

    public void setIdFlaw(int idFlaw) {
        this.idFlaw = idFlaw;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
