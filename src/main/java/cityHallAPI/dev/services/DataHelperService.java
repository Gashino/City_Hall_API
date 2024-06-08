package cityHallAPI.dev.services;

import cityHallAPI.dev.dtos.SiteDTO;
import cityHallAPI.dev.entitys.Flaw;
import cityHallAPI.dev.entitys.Neighbor;
import cityHallAPI.dev.entitys.Site;
import cityHallAPI.dev.entitys.User;
import cityHallAPI.dev.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataHelperService {

    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private FlawRepository flawRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private NeighborRepository neighborRepository;
    @Autowired
    private UserRepository userRepository;

    public List<SiteDTO> getSites(){
        List<Site> sites = siteRepository.findAll();
        List<SiteDTO> sitesFinal = new ArrayList<>();

        sites.forEach(site -> {
            SiteDTO siteDTO = new SiteDTO();
            siteDTO.Id = site.getSiteId();
            siteDTO.Description = site.getDescription() + " - " + site.getStreet() + " " + site.getNumber() ;
            sitesFinal.add(siteDTO);
        });

        return sitesFinal;
    }

    public List<Flaw> getFlaws(){
        return flawRepository.findAll();
    }

    public List<Neighbor> getNeighbors(){
        return neighborRepository.findAll();}
}
