package cityHallAPI.dev.controllers;

import cityHallAPI.dev.entitys.ProfesionalService;
import cityHallAPI.dev.entitys.Service;
import cityHallAPI.dev.exceptions.ServiceException;
import cityHallAPI.dev.interfaces.IServicesService;
import cityHallAPI.dev.utill.ServiceProfesionalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{idService}")
    public ResponseEntity<Object> getService(@PathVariable int idService) {
        try {
            Service service = servicesService.getService(idService);
            return new ResponseEntity<>(service, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{idService}")
    public ResponseEntity<Object> deleteService(@PathVariable int idService) {
        try {
            servicesService.deleteService(idService);
            return new ResponseEntity<>("Service deleted", HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createService(@RequestBody Service service) {
        try {
            servicesService.addNormalService(service.getDocument(), service.getTitle(), service.getDescription(), service.getImages());
            return new ResponseEntity<>("Service created", HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create/profesional")
    public ResponseEntity<Object> createProfesionalService(@RequestBody ServiceProfesionalDTO service) {
        try {
            servicesService.addProfesionalService(service.getDocument(),service.getTitle(),service.getDescription(),service.getImages(),service.getHours(),service.getCategoryId(),service.getName(),service.getSurname());
            return new ResponseEntity<>("Service created", HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
