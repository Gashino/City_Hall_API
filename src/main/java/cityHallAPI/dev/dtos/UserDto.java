package cityHallAPI.dev.dtos;

public class UserDto {

    String name;

    String lastName;

    String document;

    String email;

    public boolean isActive;


    public UserDto(String name, String lastName, String document,
                   String email) {
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.email = email;
    }
}
