package cityHallAPI.dev.interfaces;

import cityHallAPI.dev.dtos.ServiceDto;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

public interface IServicesService {

    public void addNormalService(String title, String description) throws ServiceException;

    public void addProfesionalService(String title, String description, String name, String surname,String category,String hours) throws ServiceException;

    public void deleteService(int idService) throws ServiceException;

    public ServiceDto getService(int idService) throws ServiceException;

    public List<ServiceDto> getAllServices() throws ServiceException;
}
