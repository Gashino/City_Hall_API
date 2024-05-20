package cityHallAPI.dev.controllers;

import cityHallAPI.dev.exceptions.UserException;
import cityHallAPI.dev.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class UserControler {

    @Autowired
    private IUserService userService;

    @PostMapping("/register?dni={dni}&email={email}")
    public ResponseEntity<Object> createUser(String dni, String email) {
        try {
            userService.addUser(dni, email);
            //devuelve un estado 201 (creado)
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (UserException e) {
            e.printStackTrace();
            //devuelve un mensaje de error y un estado 400
            ResponseEntity<Object> respuesta = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            return respuesta;

        }

    }


}
