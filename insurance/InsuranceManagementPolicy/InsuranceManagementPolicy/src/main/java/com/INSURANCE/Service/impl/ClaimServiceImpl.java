package com.INSURANCE.Service.impl;

import com.INSURANCE.Entities.Claim;
import com.INSURANCE.Entities.InsurancePolicy;
import com.INSURANCE.Exception.ClaimNotFound;
import com.INSURANCE.Exception.InsurancePolicyNotFound;
import com.INSURANCE.Payload.ClaimDTO;
import com.INSURANCE.Repository.ClaimRepository;
import com.INSURANCE.Repository.InsurancePolicyRepository;
import com.INSURANCE.Service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ClaimServiceImpl implements ClaimService {
@Autowired
    private ClaimRepository claimRepository;
@Autowired
    private final InsurancePolicyRepository insurancePolicyRepository;

    public ClaimServiceImpl(ClaimRepository claimRepository, InsurancePolicyRepository insurancePolicyRepository) {
        this.claimRepository = claimRepository;
        this.insurancePolicyRepository = insurancePolicyRepository;
    }

    @Override
    public List<ClaimDTO> getAllClaims() {

        List<Claim> claims = claimRepository.findAll();
     return  claims.stream().map(claim -> mapToDTO(claim)).collect(Collectors.toList());
    }

    @Override
    public ClaimDTO getClaimById(Long id) {
        Claim claim = claimRepository.findById(id).orElseThrow(() -> new ClaimNotFound("claim", "id", id));
        return mapToDTO(claim);
    }

    @Override
    public ClaimDTO createClaim(ClaimDTO claimDTO, Long policyNumber) {
        InsurancePolicy insurancePolicy1 = insurancePolicyRepository.findById(policyNumber).orElseThrow(() -> new InsurancePolicyNotFound("insurancepolicy", "id", policyNumber));


//        InsurancePolicy insurancePolicy = insurancePolicyRepository.findByPolicyNumber(policyNumber)
//                .orElseThrow(() -> new InsurancePolicyNotFound("insurancepolicy","id",policyNumber));

        Claim claim = mapToEntity(claimDTO);
        claim.setInsurancePolicy(insurancePolicy1);

        Claim savedClaim = claimRepository.save(claim);
        return mapToDTO(savedClaim);
    }

//    @Override
//    public ClaimDTO createClaim(ClaimDTO claimDTO, long policyNumber) {
//
//        InsurancePolicy insurancePolicy1 = insurancePolicyRepository.findById(policyNumber).orElseThrow(() -> new InsurancePolicyNotFound("insurancepolicy", "id", policyNumber));
//
//
////        InsurancePolicy insurancePolicy = insurancePolicyRepository.findByPolicyNumber(policyNumber)
////                .orElseThrow(() -> new InsurancePolicyNotFound("insurancepolicy","id",policyNumber));
//
//        Claim claim = mapToEntity(claimDTO);
//        claim.setInsurancePolicy(insurancePolicy1);
//
//        Claim savedClaim = claimRepository.save(claim);
//        return mapToDTO(savedClaim);
//    }

    @Override
    public ClaimDTO updateClaim(Long id, ClaimDTO claimDTO) {
        Claim existingClaim = claimRepository.findById(id).orElseThrow(() -> {
            return new ClaimNotFound("claim", "id", id);
        });
       existingClaim.setClaimDate(claimDTO.getClaimDate());
       existingClaim.setClaimStatus(claimDTO.getClaimStatus());
       existingClaim.setClaimNumber(claimDTO.getClaimNumber());

       existingClaim.setDescription(claimDTO.getDescription());
       existingClaim.setId(claimDTO.getId());

       existingClaim.setInsurancePolicy(claimDTO.getInsurancePolicy());
        Claim save = claimRepository.save(existingClaim);

        return  mapToDTO(save);

    }

    @Override
    public void deleteClaim(Long id) {
        if (!claimRepository.existsById(id)) {
            throw new ClaimNotFound("Claim","id",id);
        }
        claimRepository.deleteById(id);
    }



    public ClaimDTO mapToDTO(Claim claim){

        ClaimDTO claimDTO = new ClaimDTO();
        claimDTO.setClaimDate(claim.getClaimDate());
        claimDTO.setClaimNumber(claim.getClaimNumber());
        claimDTO.setClaimStatus(claim.getClaimStatus());
        claimDTO.setDescription(claim.getDescription());
        claimDTO.setId(claim.getId());
        claimDTO.setInsurancePolicy(claim.getInsurancePolicy());
        return claimDTO;

    }



    public Claim mapToEntity(ClaimDTO claimDTO){

        Claim claim = new Claim();
        claim.setClaimDate(claimDTO.getClaimDate());
        claim.setClaimNumber(claimDTO.getClaimNumber());
        claim.setClaimStatus(claimDTO.getClaimStatus());
        claim.setDescription(claimDTO.getDescription());
        claim.setId(claimDTO.getId());
        claim.setInsurancePolicy(claimDTO.getInsurancePolicy());
        return claim;

    }






}

