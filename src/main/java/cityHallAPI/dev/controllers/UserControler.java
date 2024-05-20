package cityHallAPI.dev.controllers;

import cityHallAPI.dev.dtos.UserDto;
import cityHallAPI.dev.exceptions.UserException;
import cityHallAPI.dev.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class UserControler {

    @Autowired
    private IUserService userService;

    @PostMapping("/register?dni={dni}&email={email}")
    public ResponseEntity<Object> createUser(@RequestParam("dni") String dni,
                                             @RequestParam("email") String email) {
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

    @PostMapping("/auth/login")
    public ResponseEntity<Object> login(@RequestBody String email,
                                        @RequestBody String password) {
        try {
            UserDto uDto = userService.login(email, password);
            //devuelve un estado 200 (ok)
            return new ResponseEntity<>(uDto,HttpStatus.OK);
        } catch (UserException e) {
            e.printStackTrace();
            //devuelve un mensaje de error y un estado 400
            ResponseEntity<Object> respuesta = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            return respuesta;
        }
    }

    @PutMapping("/person/changePassword")
    public ResponseEntity<Object> changePassword(@RequestBody String email,
                                                @RequestBody String newPassword) {
        try {
            userService.changePassword(email, newPassword);
            //devuelve un estado 200 (ok)
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserException e) {
            e.printStackTrace();
            //devuelve un mensaje de error y un estado 400
            ResponseEntity<Object> respuesta = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            return respuesta;
        }
    }


}
