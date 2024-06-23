package cityHallAPI.dev.interfaces;

import cityHallAPI.dev.dtos.ComplaintDTO;
import cityHallAPI.dev.entitys.Complaint;
import cityHallAPI.dev.exceptions.ComplaintException;
import cityHallAPI.dev.utill.Status;

import java.util.List;

public interface IComplaintService {

    public void addComplaint(String document, int idSite,String description, String documentDenounced,List<String>images) throws ComplaintException;

    public List<ComplaintDTO> getComplaintsByUser(String document) throws ComplaintException;

    public ComplaintDTO getComplaintDetails(int idComplaint) throws ComplaintException;

}
