package cityHallAPI.dev.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicios")
public class ProfesionalService extends Service{

    @Column(name = "horarios")
    private String hours;

    @Column(name = "rubro")
    private String category;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String surname;


    public ProfesionalService(){}

    public ProfesionalService(String document, String title, String description, String hours, String category, String name, String surname) {
        super(document, title, description);
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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
