package cityHallAPI.dev.dtos;

import cityHallAPI.dev.entitys.Complaint;
import cityHallAPI.dev.entitys.Site;

import java.util.List;

public class ComplaintDTO {
    public int idComplaint;
    public String siteStreet;
    public int siteNumber;
    public String description;
    public String status;
    public String documentDenounced;
    public List<String> images;


    public ComplaintDTO(Complaint x){
        idComplaint = x.getIdComplaint();
        siteStreet = (x.getSite() == null) ? null : x.getSite().getStreet();
        siteNumber = (x.getSite() == null) ? 0 : x.getSite().getNumber();
        documentDenounced = (x.getUser() == null) ? null : x.getUser().getDocument();
        description = x.getDescription();
        status = x.getStatus();
        images = x.getImages();
    }

    public int getIdComplaint() {
        return idComplaint;
    }

    public void setIdComplaint(int idComplaint) {
        this.idComplaint = idComplaint;
    }

    public String getSiteStreet() {
        return siteStreet;
    }

    public void setSiteStreet(String siteStreet) {
        this.siteStreet = siteStreet;
    }

    public int getSiteNumber() {
        return siteNumber;
    }

    public void setSiteNumber(int siteNumber) {
        this.siteNumber = siteNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDocumentDenounced() {
        return documentDenounced;
    }

    public void setDocumentDenounced(String documentDenounced) {
        this.documentDenounced = documentDenounced;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}


