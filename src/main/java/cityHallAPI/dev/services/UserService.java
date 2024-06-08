package cityHallAPI.dev.services;

import cityHallAPI.dev.dtos.UserAdminDto;
import cityHallAPI.dev.dtos.UserDto;
import cityHallAPI.dev.entitys.Employee;
import cityHallAPI.dev.entitys.Neighbor;
import cityHallAPI.dev.entitys.User;
import cityHallAPI.dev.exceptions.UserException;
import cityHallAPI.dev.interfaces.IUserService;
import cityHallAPI.dev.repository.EmployeeRepository;
import cityHallAPI.dev.repository.NeighborRepository;
import cityHallAPI.dev.repository.UserRepository;
import cityHallAPI.dev.utill.PasswordGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    NeighborRepository neighborRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmailSender emailSender;

    public UserService() {

    }

    @Override
    public void addUser(String document, String email) throws UserException, IllegalAccessError{

        Optional<Neighbor> neighbor = neighborRepository.findById(document);

        Optional<User> user = userRepository.findById(document);
        if(user.isPresent()){
            throw new IllegalAccessError("Usuario ya registrado");
        }

        if(neighbor.isPresent()){

            String password = PasswordGenerator.getAlphaNumericString(8);
            User newUser = new User(document,email,password);
            userRepository.save(newUser);

            emailSender.sendEmail(email,"Registro exitoso","Muchas gracias por registrarse en el sistema CityHall..." +
                    "Su clave es: " + password);
        }
        else{
            throw new UserException("Error registrando el usuario");
        }
    }

    @Override
    public UserDto login(String access, String password) throws UserException{
        Optional<User> userOptional = userRepository.findByEmailAndPassword(access,password);

        Optional<Employee> employeeOptional = access.matches("[0-9]+") ?
                employeeRepository.findByEmployeeIdAndPassword(Integer.parseInt(access),password) : Optional.empty();

        if(userOptional.isPresent()) {
            User user = userOptional.get();
            Neighbor neighbor = neighborRepository.findById(user.getDocument()).get();

            UserDto userDto= new UserDto()
            {{
                name= neighbor.getName();
                surname=neighbor.getSurname();
                direction= neighbor.getAdress();
                document= neighbor.getDocument();
                email= user.getEmail();
                district = neighbor.getDistrict().getName();
                isAdmin = false;
            }};

            if(user.isActive()){
                userDto.isActive = true;
                return userDto;
            }
            throw new UserException("Usuario inactivo");
        }
        else if(employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();

            return new UserAdminDto()
            {{
                name= employee.getName();
                surname=employee.getLastName();
                document= employee.getDocument();
                employeeId= employee.getEmployeeId();
                isAdmin = true;
                department = employee.getDepartment();
                category = employee.getCategory();
                startDate = employee.getStartDate();
            }};
        }
        else{
            throw new UserException("Usuario invalido");
        }
    }

    @Override
    public void changePassword(String mail, String newPassword) throws UserException{
        Optional<User> userOpt = userRepository.findByEmail(mail);

        if(userOpt.isPresent()){
            User user = userOpt.get();
            user.setPassword(newPassword);

            userRepository.save(user);
        }
        else {
            throw new UserException("Error cambiando la clave...");
        }
    }

    @Override
    public void forgotPassword(String mail) throws UserException{
        Optional<User> userOpt = userRepository.findByEmail(mail);
        if(userOpt.isPresent()){
            User user = userOpt.get();

            emailSender.sendEmail(mail,"Recuperar clave","Su clave es: " + user.getPassword());

        }
    }

}
