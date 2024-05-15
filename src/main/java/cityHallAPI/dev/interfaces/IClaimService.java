package cityHallAPI.dev.interfaces;

import cityHallAPI.dev.entitys.Claim;
import cityHallAPI.dev.exceptions.ClaimException;

import java.util.List;

public interface IClaimService {

public void createClaim(String document, int employeeId, int idFlaw,int idSite, String description, String status) throws ClaimException;

//TODO -> PODEMOS ENVIAR MENOS INFORMACION AL FRONT MEDIANTE DTOS SIMPLES.
public List<Claim> getAllClaims() throws ClaimException;

public Claim getClaimById(int id) throws ClaimException;
}