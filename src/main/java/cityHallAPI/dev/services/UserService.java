package cityHallAPI.dev.services;

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
        }
        else{
            throw new UserException("Error agregando el usuario.");
        }
    }

    @Override
    public void login(String email, String password) throws UserException{

    }

    @Override
    public void changePassword(String mail, String password) throws UserException{

    }

    @Override
    public void forgotPassword(String mail) throws UserException{

    }
}
