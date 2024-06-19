package cityHallAPI.dev.controllers;

import cityHallAPI.dev.dtos.UserDto;
import cityHallAPI.dev.dtos.UserLoginDTO;
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

    @PostMapping("/register")
    public ResponseEntity<Object> createUser(@RequestParam("dni") String dni,
                                             @RequestParam("email") String email,
                                             @RequestParam("tokenPush") String tokenPush){
        try {
            System.out.println("dni: " + dni + " email: " + email + " tokenPush: " + tokenPush);
            userService.addUser(dni, email,tokenPush);
            //devuelve un estado 201 (creado)
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (UserException e) {
            e.printStackTrace();
            //devuelve un mensaje de error y un estado 400
            ResponseEntity<Object> respuesta = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            return respuesta;
        } catch (IllegalAccessError e) {
            e.printStackTrace();
            //devuelve un mensaje de error y un estado 409
            ResponseEntity<Object> respuesta = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
            return respuesta;
        }

    }

    @PostMapping("/auth/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginDTO userLoginDTO) {
        try {
            UserDto uDto = userService.login(userLoginDTO.access, userLoginDTO.password);
            //devuelve un estado 200 (ok)
            return new ResponseEntity<>(uDto,HttpStatus.OK);
        } catch (UserException e) {
            e.printStackTrace();
            //devuelve un mensaje de error y un estado 400
            ResponseEntity<Object> respuesta = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            return respuesta;
        }
    }

    @PutMapping("/changePassword")
    public ResponseEntity<Object> changePassword(@RequestBody UserLoginDTO userLoginDTO) {
        try {
            userService.changePassword(userLoginDTO.access, userLoginDTO.password);
            //devuelve un estado 200 (ok)
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserException e) {
            e.printStackTrace();
            //devuelve un mensaje de error y un estado 400
            ResponseEntity<Object> respuesta = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            return respuesta;
        }
    }

    @PostMapping("/forgotPassword")
    public ResponseEntity<Object> forgotPassword(@RequestParam("email") String email) {
        try {
            userService.forgotPassword(email);
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
