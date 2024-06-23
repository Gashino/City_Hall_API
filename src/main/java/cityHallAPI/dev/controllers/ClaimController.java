package cityHallAPI.dev.controllers;

import cityHallAPI.dev.dtos.PostClaimDTO;
import cityHallAPI.dev.entitys.Claim;
import cityHallAPI.dev.interfaces.IClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claim")
public class ClaimController {

    @Autowired
    private IClaimService claimService;

    @GetMapping("/")
    public ResponseEntity<Object> getAllClaims() {
        try {
            List<Claim> claims = claimService.getAllClaims();
            return new ResponseEntity<>(claims, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createClaim(@RequestBody PostClaimDTO claim) {
        try {
            claimService.createClaim(claim.document, claim.idFlaw, claim.idSite, claim.description, claim.images);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClaimById(@PathVariable int id) {
        try {
            Claim claim = claimService.getClaimById(id);
            return new ResponseEntity<>(claim, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<Object> getReclamoByCategory(@RequestParam int rubro) {
        try {
            List<Claim> claims = claimService.getByCategoryId(rubro);
            return new ResponseEntity<>(claims, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
