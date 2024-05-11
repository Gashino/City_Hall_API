package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "personal")
public class Employee {

    @Id
    @Column(name = "legajo")
    private int employeeId;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "documento")
    private String document;

    @Column(name = "sector")
    private String Department;

    @ManyToOne
    @JoinColumn(name = "idRubro")
    private Category category; //TODO

    @Column(name = "fechaIngreso")
    private Date startDate;

    public Employee() {
    }

    public Employee(String name, String lastName, String document, String department, Category category, Date startDate) {
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        Department = department;
        this.category = category;
        this.startDate = startDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getDepartment() {
        return Department;
    }

    public Category getCategory() {
        return category;
    }

    public Date getStartDate() {
        return startDate;
    }
}
