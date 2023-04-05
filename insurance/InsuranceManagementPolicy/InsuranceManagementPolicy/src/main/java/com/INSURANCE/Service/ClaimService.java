package com.INSURANCE.Service;

import com.INSURANCE.Payload.ClaimDTO;
import com.INSURANCE.Payload.InsurancePolicyDTO;

import java.util.List;

public interface ClaimService {
    List<ClaimDTO> getAllClaims();
    ClaimDTO getClaimById(Long id);
    ClaimDTO createClaim(ClaimDTO claimDTO,Long  policyNumber);
    ClaimDTO updateClaim(Long id, ClaimDTO claimDTO);
    void deleteClaim(Long id);
}
