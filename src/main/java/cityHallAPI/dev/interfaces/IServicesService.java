package cityHallAPI.dev.interfaces;

import cityHallAPI.dev.entitys.Service;
import cityHallAPI.dev.exceptions.ServiceException;

import java.util.List;

public interface IServicesService {

    public void addNormalService(String document,String title, String description) throws ServiceException;

    public void addProfesionalService(String document, String title, String description, String hours, String category, String name, String surname) throws ServiceException;

    public void deleteService(int idService) throws ServiceException;

    public Service getService(int idService) throws ServiceException;

    public List<Service> getAllServices() throws ServiceException;
}
