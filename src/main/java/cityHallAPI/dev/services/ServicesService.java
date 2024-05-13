package cityHallAPI.dev.services;

import cityHallAPI.dev.dtos.ServiceDto;
import cityHallAPI.dev.entitys.ProfesionalService;
import cityHallAPI.dev.entitys.Service;
import cityHallAPI.dev.interfaces.IServicesService;
import cityHallAPI.dev.repository.ServiceRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ServicesService implements IServicesService {

    @Autowired
    ServiceRepository serviceRepository;


    @Override
    public void addNormalService(String document, String title, String description) throws ServiceException {
        try{
            Service service = new Service(document, title, description);
            serviceRepository.save(service);
        }catch(Exception e){
            throw new ServiceException("Error agregando el servicio!");
        }
    }

    @Override
    public void addProfesionalService(String document, String title, String description, String hours, String category, String name, String surname) throws ServiceException {
        try{
            Service service = new ProfesionalService(document, title, description, hours,category,name,surname);
            serviceRepository.save(service);
        }catch(Exception e){
            throw new ServiceException("Error agregando el servicio!");
        }
    }

    @Override
    public void deleteService(int idService) throws ServiceException {
        try{
            serviceRepository.deleteById(idService);
        }catch (Exception e){
            throw new ServiceException("Error eliminando el servicio!");
        }
    }

    @Override
    public Service getService(int idService) throws ServiceException {
        Optional<Service> serviceOptional = serviceRepository.findById(idService);

        if(serviceOptional.isPresent()){
            return serviceOptional.get();
        }
        else{
            throw new ServiceException("Error al obtener el servicio");
        }
    }

    @Override
    public List<Service> getAllServices() throws ServiceException {
        return serviceRepository.findAll();
    }
}