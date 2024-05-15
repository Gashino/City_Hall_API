package cityHallAPI.dev.services;

import cityHallAPI.dev.entitys.Claim;
import cityHallAPI.dev.exceptions.ClaimException;
import cityHallAPI.dev.interfaces.IClaimService;

import java.util.List;

public class ClaimService implements IClaimService {

    @Override
    public void createClaim(String document, int employeeId, int idFlaw, int idSite, String description, String status) throws ClaimException {

    }

    @Override
    public List<Claim> getAllClaims() throws ClaimException {
        return List.of();
    }

    @Override
    public Claim getClaimById(int id) throws ClaimException {
        return null;
    }
}
