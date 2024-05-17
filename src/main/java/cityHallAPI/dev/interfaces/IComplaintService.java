package cityHallAPI.dev.interfaces;

import cityHallAPI.dev.entitys.Complaint;
import cityHallAPI.dev.exceptions.ComplaintException;
import cityHallAPI.dev.utill.Status;

import java.util.List;

public interface IComplaintService {

    //Denunciado??//TODO
    public void adComplaint(String document, int idSite,String description, String status) throws ComplaintException;

    public List<Complaint> getComplaintsByUser(String document) throws ComplaintException;

    public Complaint getComplaintDetails(int idComplaint) throws ComplaintException;

}
