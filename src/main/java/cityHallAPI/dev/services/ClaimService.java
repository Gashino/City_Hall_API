package cityHallAPI.dev.services;

import cityHallAPI.dev.entitys.*;
import cityHallAPI.dev.exceptions.ClaimException;
import cityHallAPI.dev.interfaces.IClaimService;
import cityHallAPI.dev.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimService implements IClaimService {

    @Autowired
    ClaimRepository claimRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SiteRepository siteRepository;
    @Autowired
    FlawRepository flawRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void createClaim(String document, int idFlaw, int idSite, String description,List<String> images) throws ClaimException {
        Optional<User> userOptional = userRepository.findById(document);
        Optional<Employee> employeeOptional = employeeRepository.findByDocument(document);

        Optional<Site> siteOptional = siteRepository.findById(idSite);
        Optional<Flaw> flawOptional = flawRepository.findById(idFlaw);

        if((userOptional.isEmpty() && employeeOptional.isEmpty()) || siteOptional.isEmpty() || flawOptional.isEmpty()){
            throw new ClaimException("User, Site or Flaw not found");
        }
        else{
            if(userOptional.isEmpty()){
                Employee employee = employeeOptional.get();
                Site site = siteOptional.get();
                Flaw flaw = flawOptional.get();
                Claim claim = new Claim(null, employee, site, flaw, description,images);
                claimRepository.save(claim);
            }
            else {
                User user = userOptional.get();
                Site site = siteOptional.get();
                Flaw flaw = flawOptional.get();
                Claim claim = new Claim(user, null, site, flaw, description,images);
                claimRepository.save(claim);
            }
        }
    }

    @Override
    public List<Claim> getAllClaims() throws ClaimException {
        return claimRepository.findAllReclamos();
    }

    @Override
    public Claim getClaimById(int id) throws ClaimException {
        Optional<Claim> claimOptional = claimRepository.findById(id);
        if(claimOptional.isEmpty()){
            throw new ClaimException("Claim not found");
        }
        return claimOptional.get();
    }

    @Override
    public List<Claim> getByCategoryId(int idCategory) {
        return claimRepository.findByCategoryId(idCategory);
    }
}
