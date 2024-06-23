package cityHallAPI.dev.services;

import cityHallAPI.dev.entitys.Category;
import cityHallAPI.dev.entitys.ProfesionalService;
import cityHallAPI.dev.entitys.Service;
import cityHallAPI.dev.exceptions.ServiceException;
import cityHallAPI.dev.interfaces.IServicesService;
import cityHallAPI.dev.repository.CategoryRepository;
import cityHallAPI.dev.repository.ServiceRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServicesService implements IServicesService {

    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public void addNormalService(String document, String title, String description,List<String> images) throws ServiceException {
        try{
            Service service = new Service(document, title, description,images);
            serviceRepository.save(service);
        }catch(Exception e){
            throw new ServiceException("Error agregando el servicio!");
        }
    }

    @Override
    public void addProfesionalService(String document, String title, String description, List<String> images, String hours, int idCategory, String name, String surname) throws ServiceException {
        try{
            Category category = categoryRepository.findById(idCategory).get();
            Service service = new ProfesionalService(document, title, description,images,hours,category,name,surname);
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
        List<Service> services = serviceRepository.findAll();
        return services.stream()
                .filter(Service::isActive)
                .collect(Collectors.toList());
    }
}
