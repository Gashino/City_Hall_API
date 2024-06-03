package cityHallAPI.dev.services;

import cityHallAPI.dev.dtos.SiteDTO;
import cityHallAPI.dev.entitys.Flaw;
import cityHallAPI.dev.entitys.Site;
import cityHallAPI.dev.repository.CategoryRepository;
import cityHallAPI.dev.repository.FlawRepository;
import cityHallAPI.dev.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataHelperService {

    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private FlawRepository flawRepository;
    @Autowired
    private CategoryRepository categoryRepository;


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
}
