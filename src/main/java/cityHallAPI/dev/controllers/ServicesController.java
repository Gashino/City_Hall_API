package cityHallAPI.dev.controllers;

import cityHallAPI.dev.entitys.Service;
import cityHallAPI.dev.exceptions.ServiceException;
import cityHallAPI.dev.interfaces.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/service")
public class ServicesController {

    @Autowired
    private IServicesService servicesService;


    @GetMapping("/")
    public ResponseEntity<Object> getServices() {
        try {
            List<Service> services = servicesService.getAllServices();
            return new ResponseEntity<>(services, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
