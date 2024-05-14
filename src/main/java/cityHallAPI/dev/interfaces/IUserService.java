package cityHallAPI.dev.interfaces;

import cityHallAPI.dev.dtos.UserAdminDto;
import cityHallAPI.dev.dtos.UserDto;
import cityHallAPI.dev.exceptions.UserException;

public interface IUserService {

    public void addUser(String document, String email, String password) throws UserException;

    public UserDto login(String email, String password) throws UserException;

    public void changePassword(String mail, String password) throws UserException;

    public void forgotPassword(String mail) throws UserException;
}
