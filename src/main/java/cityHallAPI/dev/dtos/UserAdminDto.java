package cityHallAPI.dev.dtos;


import cityHallAPI.dev.entitys.Category;

import java.util.Date;

public class UserAdminDto extends UserDto {

    public int employeeId;

    public String department;

    public Category category;

    public Date startDate;



       public UserAdminDto(String name, String surname, String document, String email, int employeeId, String department, Category category, Date startDate) {
            super(name, surname, document, email);
            this.employeeId = employeeId;
            this.department = department;
            this.category = category;
            this.startDate = startDate;
            this.isActive = true;
        }

    public UserAdminDto() {
        super();
    }
}
