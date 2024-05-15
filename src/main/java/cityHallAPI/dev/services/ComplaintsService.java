package cityHallAPI.dev.services;

import cityHallAPI.dev.entitys.Complaint;
import cityHallAPI.dev.exceptions.ComplaintException;
import cityHallAPI.dev.interfaces.IComplaintService;
import cityHallAPI.dev.repository.CategoryRepository;
import cityHallAPI.dev.repository.ComplaintRepository;
import cityHallAPI.dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ComplaintsService implements IComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;
    UserRepository userRepository;
    CategoryRepository categoryRepository;


    @Override
    public void adComplaint(String document, int idSite, String description, String status) throws ComplaintException {

    }

    @Override
    public List<Complaint> getComplaintsByUser(String document) throws ComplaintException {
        return List.of();
    }

    @Override
    public Complaint getComplaintDetails(int idComplaint) throws ComplaintException {
        return null;
    }
}
