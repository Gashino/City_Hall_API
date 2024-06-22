package cityHallAPI.dev.utill;

public class ServiceProfesionalDTO {

    private String document;
    private String title;
    private String description;
    private String hours;
    private int categoryId;
    private String name;
    private String surname;

    public ServiceProfesionalDTO(int categoryId, String document, String title, String description, String hours, String name, String surname) {
        this.categoryId = categoryId;
        this.document = document;
        this.title = title;
        this.description = description;
        this.hours = hours;
        this.name = name;
        this.surname = surname;
    }
    public ServiceProfesionalDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
