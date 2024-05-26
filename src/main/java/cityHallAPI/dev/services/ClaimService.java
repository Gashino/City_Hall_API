package cityHallAPI.dev.services;

import cityHallAPI.dev.entitys.Claim;
import cityHallAPI.dev.entitys.Flaw;
import cityHallAPI.dev.entitys.Site;
import cityHallAPI.dev.entitys.User;
import cityHallAPI.dev.exceptions.ClaimException;
import cityHallAPI.dev.interfaces.IClaimService;
import cityHallAPI.dev.repository.ClaimRepository;
import cityHallAPI.dev.repository.FlawRepository;
import cityHallAPI.dev.repository.SiteRepository;
import cityHallAPI.dev.repository.UserRepository;
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

    @Override
    public void createClaim(String document, int idFlaw, int idSite, String description) throws ClaimException {
        Optional<User> userOptional = userRepository.findById(document);
        Optional<Site> siteOptional = siteRepository.findById(idSite);
        Optional<Flaw> flawOptional = flawRepository.findById(idFlaw);

        if(userOptional.isEmpty() || siteOptional.isEmpty() || flawOptional.isEmpty()){
            throw new ClaimException("User, Site or Flaw not found");
        }
        else{
            User user = userOptional.get();
            Site site = siteOptional.get();
            Flaw flaw = flawOptional.get();
            Claim claim = new Claim(user, null, site, flaw, description);
            claimRepository.save(claim);
        }
    }

    @Override
    public List<Claim> getAllClaims() throws ClaimException {
        return claimRepository.findAll();
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
