package cityHallAPI.dev.services;

import cityHallAPI.dev.dtos.ComplaintDTO;
import cityHallAPI.dev.entitys.Complaint;
import cityHallAPI.dev.entitys.Site;
import cityHallAPI.dev.entitys.User;
import cityHallAPI.dev.exceptions.ComplaintException;
import cityHallAPI.dev.interfaces.IComplaintService;
import cityHallAPI.dev.repository.CategoryRepository;
import cityHallAPI.dev.repository.ComplaintRepository;
import cityHallAPI.dev.repository.SiteRepository;
import cityHallAPI.dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComplaintsService implements IComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;
    UserRepository userRepository;
    CategoryRepository categoryRepository;
    SiteRepository siteRepository;



    @Override
    public void adComplaint(String document, int idSite, String description,String documentDenounced) throws ComplaintException {
            Optional<User> userOptional = userRepository.findById(document);
            Optional<User> denouncedOptional = userRepository.findById(documentDenounced);
            Optional<Site> siteOptional = siteRepository.findById(idSite);
            Complaint complaint;

            if(userOptional.isPresent() && (denouncedOptional.isPresent() || siteOptional.isPresent())){
                User userDenunciante = userOptional.get();

                if(denouncedOptional.isPresent()){
                User userDenunciado = denouncedOptional.get();
                complaint = new Complaint(userDenunciante,null,description,userDenunciado);
                }
                else{
                Site site = siteOptional.get();
                complaint = new Complaint(userDenunciante,site,description,null);
                }
                complaintRepository.save(complaint);
            }
            else{
                throw new ComplaintException("Usuario, sitio o denunciado no encontrado");
            }
    }

    @Override
    public List<ComplaintDTO> getComplaintsByUser(String document) throws ComplaintException {
        Optional<User> userOptional = userRepository.findById(document);
        if(userOptional.isPresent()){
            List<ComplaintDTO> complaintsDTO = new ArrayList<>();
            List<Complaint> complaints = complaintRepository.findByUser(userOptional.get());
            complaints.addAll(complaintRepository.findByDenounced(userOptional.get()));
            complaints.forEach(x -> complaintsDTO.add(new ComplaintDTO(){
                {
                    idComplaint = x.getIdComplaint();
                    document = x.getUser().getDocument();
                    siteStreet = x.getSite().getStreet();
                    siteNumber = x.getSite().getNumber();
                    description = x.getDescription();
                    status = x.getStatus().toString();
                    documentDenounced = x.getDenounced().getDocument();
                }
            }));
            return complaintsDTO;
        }
        else{
            throw new ComplaintException("Usuario no encontrado");
        }
    }

    @Override
    public Complaint getComplaintDetails(int idComplaint) throws ComplaintException {
        Optional<Complaint> complaintOptional = complaintRepository.findById(idComplaint);
        if(complaintOptional.isPresent()){
            return complaintOptional.get();
        }
        else{
            throw new ComplaintException("Denuncia no encontrada");
        }
    }
}
