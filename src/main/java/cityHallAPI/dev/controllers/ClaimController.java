package cityHallAPI.dev.controllers;

import cityHallAPI.dev.entitys.Claim;
import cityHallAPI.dev.interfaces.IClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
