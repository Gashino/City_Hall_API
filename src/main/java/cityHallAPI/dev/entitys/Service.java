package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "servicios")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tiposervicio", discriminatorType = DiscriminatorType.STRING)
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idservicio")
    private int idService;

    @Column(name = "documento")
    private String document;

    @Column(name = "titulo")
    private String title;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "isactive")
    private boolean isActive;

    @Column(name = "isprofesional")
    private boolean isProfesional;

    @ElementCollection
    @CollectionTable(
            name = "imagenesservicio",
            joinColumns = @JoinColumn(name = "idservicio")
    )
    @Column(name = "nombrearchivo")
    private List<String> images;

    public Service(){}

    public Service(String document, String title, String description, List<String> images) {
        this.document = document;
        this.title = title;
        this.description = description;
        this.isActive = false;
        this.isProfesional = false;
        this.images = images;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isProfesional() {
        return isProfesional;
    }

    public void setProfesional(boolean profesional) {
        isProfesional = profesional;
    }
}
