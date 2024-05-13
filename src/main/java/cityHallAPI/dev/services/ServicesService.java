package cityHallAPI.dev.services;

import cityHallAPI.dev.dtos.ServiceDto;
import cityHallAPI.dev.interfaces.IServicesService;

import java.util.List;

public class ServicesService implements IServicesService {

    @Override
    public void addNormalService(String title, String description) {

    }

    @Override
    public void addProfesionalService(String title, String description, String name, String surname, String category, String hours) {

    }

    @Override
    public void deleteService(int idService) {

    }

    @Override
    public ServiceDto getService(int idService) {
        return null;
    }

    @Override
    public List<ServiceDto> getAllServices() {
        return null;
    }
}
