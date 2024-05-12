package cityHallAPI.dev.services;

import cityHallAPI.dev.dtos.UserDto;
import cityHallAPI.dev.entitys.Neighbor;
import cityHallAPI.dev.entitys.User;
import cityHallAPI.dev.exceptions.UserException;
import cityHallAPI.dev.interfaces.IUserService;
import cityHallAPI.dev.repository.NeighborRepository;
import cityHallAPI.dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    NeighborRepository neighborRepository;

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
            throw new UserException("Error agregando el usuario");
        }

    }

    @Override
    public UserDto login(String email, String password) throws UserException{
        Optional<User> userOptional = userRepository.findByMailAndPassword(email,password);

        if(userOptional.isPresent()) {
            User user = userOptional.get();
            Neighbor neighbor = neighborRepository.findById(user.getDocument()).get();

            UserDto userDto = new UserDto(neighbor.getName(), neighbor.getSurname(), neighbor.getDocument(),
                    user.getEmail());

            if(user.isActive()){
                userDto.isActive = true;
                return userDto;

            }
            else return userDto;
        }
        else{
            throw new UserException("Usuario invalido");
        }
    }

    @Override
    public void changePassword(String mail, String password) throws UserException{

    }

    @Override
    public void forgotPassword(String mail) throws UserException{

    }
}
