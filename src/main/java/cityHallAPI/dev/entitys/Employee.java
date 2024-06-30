package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "personal")
public class Employee {

    @Id
    @Column(name = "legajo")
    private int employeeId;

    @Column(name = "password")
    private String password;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "documento")
    private String document;

    @Column(name = "sector")
    private String department;

    @Column(name = "categoria")
    private int internCategory;

    @ManyToOne
    @JoinTable(name = "personalrubro",
            joinColumns = @JoinColumn(name = "legajo", referencedColumnName = "legajo"),
            inverseJoinColumns = @JoinColumn(name = "idrubro", referencedColumnName = "idrubro"))
    private Category category;

    @Column(name = "fechaingreso")
    private Date startDate;

    public Employee() {
    }

    public Employee(String name, String lastName, String document, String department, int internCategory, Category category, Date startDate) {
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.department = department;
        this.internCategory = internCategory;
        this.category = category;
        this.startDate = startDate;
    }

    public int getInternCategory() {
        return internCategory;
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
        return department;
    }

    public Category getCategory() {
        return category;
    }

    public Date getStartDate() {
        return startDate;
    }
}
