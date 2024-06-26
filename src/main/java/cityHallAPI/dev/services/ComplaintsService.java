package cityHallAPI.dev.services;

import cityHallAPI.dev.dtos.ComplaintDTO;
import cityHallAPI.dev.entitys.*;
import cityHallAPI.dev.exceptions.ComplaintException;
import cityHallAPI.dev.interfaces.IComplaintService;
import cityHallAPI.dev.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ComplaintsService implements IComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SiteRepository siteRepository;
    @Autowired
    ComplaintIssuerRepository complaintIssuerRepository;
    @Autowired
    NeighborRepository neighborRepository;



    @Override
    public void addComplaint(String document, int idSite, String description,String documentDenounced,List<String>images) throws ComplaintException {
            Optional<User> userOptional = userRepository.findById(document);
            Optional<Neighbor> denouncedOptional = neighborRepository.findById(documentDenounced);
            Optional<Site> siteOptional = siteRepository.findById(idSite);
            Complaint complaint;

            if(userOptional.isPresent() && (denouncedOptional.isPresent() || siteOptional.isPresent())){
                User userDenunciante = userOptional.get();

                if(denouncedOptional.isPresent()){
                Neighbor userDenunciado = denouncedOptional.get();
                complaint = new Complaint(userDenunciado,null,description,images);
                }
                else{
                Site site = siteOptional.get();
                complaint = new Complaint(null,site,description,images);
                }
                complaintRepository.save(complaint);
                complaintIssuerRepository.save(new ComplaintIssuer(userDenunciante,complaint));
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

            List<Complaint> complaints = complaintRepository.findByDocument(document);
            complaints.forEach(x -> complaintsDTO.add(new ComplaintDTO(x)));
            return complaintsDTO;
        }
        else{
            throw new ComplaintException("Usuario no encontrado");
        }
    }

    @Override
    public ComplaintDTO getComplaintDetails(int idComplaint) throws ComplaintException {
        Optional<Complaint> complaintOptional = complaintRepository.findById(idComplaint);
        if(complaintOptional.isPresent()){
            Complaint complaint = complaintOptional.get();
            return new ComplaintDTO(complaint);
        }
        else{
            throw new ComplaintException("Denuncia no encontrada");
        }
    }
}
