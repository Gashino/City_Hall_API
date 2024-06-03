package cityHallAPI.dev.dtos;

public class UserDto {

    public String name;

    public String surname;

    public String document;

    public String email;

    public String district;

    public boolean isActive;

    public boolean isAdmin;

    public String direction;


    public UserDto(String name, String surname, String document,
                   String email) {
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.email = email;
        this.isAdmin=false;
    }

    public UserDto() {

    }
}
