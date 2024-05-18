package cityHallAPI.dev.interfaces;

import cityHallAPI.dev.dtos.ComplaintDTO;
import cityHallAPI.dev.entitys.Complaint;
import cityHallAPI.dev.exceptions.ComplaintException;
import cityHallAPI.dev.utill.Status;

import java.util.List;

public interface IComplaintService {

    public void adComplaint(String document, int idSite,String description, String documentDenounced) throws ComplaintException;

    public List<ComplaintDTO> getComplaintsByUser(String document) throws ComplaintException;

    public Complaint getComplaintDetails(int idComplaint) throws ComplaintException;

}
