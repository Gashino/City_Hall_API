package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "personal")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String name;
    private String lastName;
    private String document;
    private String Department;
    private Category category; //TODO
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

    public Long getEmployeeId() {
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
