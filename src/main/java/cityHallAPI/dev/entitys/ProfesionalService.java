package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "servicios")
@DiscriminatorValue("profesional")
public class ProfesionalService extends Service{

    @Column(name = "horarios")
    private String hours;

    @ManyToOne
    @JoinColumn(name = "rubro")
    private Category category;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String surname;


    public ProfesionalService(){}

    public ProfesionalService(String document, String title, String description, List<String> images, String hours, Category category, String name, String surname) {
        super(document, title, description,images);
        this.hours = hours;
        this.category = category;
        this.name = name;
        this.surname = surname;
        this.setProfesional(true);
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
}
