package cityHallAPI.dev.controllers;

import cityHallAPI.dev.services.DataHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private DataHelperService dataHelperService;

    @GetMapping("/sites")
    public Object getSites(){
        return dataHelperService.getSites();
    }

    @GetMapping("/flaws")
    public Object getFlaws(){
        return dataHelperService.getFlaws();
    }

    @GetMapping("/neighbors")
    public Object getNeighbors(){
        return dataHelperService.getNeighbors();
    }
}
