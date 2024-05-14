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
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Optional;

public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    NeighborRepository neighborRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void addUser(String document, String email, String password) throws UserException{

        Optional<Neighbor> neighbor = neighborRepository.findById(document);
        Optional<User> user = userRepository.findById(document);

        if(user.isEmpty() && neighbor.isPresent()){
            User newUser = new User(document,email,password);
            userRepository.save(newUser);

            //TODO -> Enviar mail(?
        }
        else{
            throw new UserException("Error registrando el usuario");
        }
    }

    @Override
    public UserDto login(String access, String password) throws UserException{
        Optional<User> userOptional = userRepository.findByEmailAndPassword(access,password);
        Optional<Employee> employeeOptional = employeeRepository.findByEmployeeIdAndPassword(Integer.parseInt(access),password);

        if(userOptional.isPresent()) {
            User user = userOptional.get();
            Neighbor neighbor = neighborRepository.findById(user.getDocument()).get();

            UserDto userDto= new UserDto()
            {{
                name= neighbor.getName();
                surname=neighbor.getSurname();
                document= neighbor.getDocument();
                email= user.getEmail();
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

            //TODO -> enviar mail!

        }
    }

}
