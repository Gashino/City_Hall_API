package cityHallAPI.dev.controllers;


import cityHallAPI.dev.dtos.ComplaintDTO;
import cityHallAPI.dev.dtos.PostComplaintDTO;
import cityHallAPI.dev.entitys.Complaint;
import cityHallAPI.dev.interfaces.IComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaint")
public class ComplaintController {

    @Autowired
    private IComplaintService complaintService;

    @PostMapping("/create")
    public ResponseEntity<Object> createComplaint(@RequestBody PostComplaintDTO complaint){
        try {
            complaintService.addComplaint(complaint.issuerDocument,complaint.siteId,complaint.description,complaint.denouncedDocument);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<Object> getComplaints(@RequestParam String document){
        try {
            List<ComplaintDTO> complaints = complaintService.getComplaintsByUser(document);
            return new ResponseEntity<>(complaints,HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getComplaint(@PathVariable int id){
        try {
            ComplaintDTO complaint = complaintService.getComplaintDetails(id);
            return new ResponseEntity<>(complaint,HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
