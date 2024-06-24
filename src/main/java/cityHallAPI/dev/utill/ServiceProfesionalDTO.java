package cityHallAPI.dev.utill;

import java.util.List;

public class ServiceProfesionalDTO {

    private String document;
    private String title;
    private String description;
    private String hours;
    private int categoryId;
    private String name;
    private String surname;
    private List<String> images;

    public ServiceProfesionalDTO(int categoryId, String document, String title, String description,List<String> images, String hours, String name, String surname) {
        this.categoryId = categoryId;
        this.document = document;
        this.title = title;
        this.description = description;
        this.hours = hours;
        this.name = name;
        this.surname = surname;
        this.images = images;
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
