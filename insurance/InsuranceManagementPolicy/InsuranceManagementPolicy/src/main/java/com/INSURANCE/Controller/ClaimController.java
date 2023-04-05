package com.INSURANCE.Controller;



import com.INSURANCE.Payload.ClaimDTO;
import com.INSURANCE.Service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping("")
    public ResponseEntity<List<ClaimDTO>> getAllClaims() {
        List<ClaimDTO> claims = claimService.getAllClaims();
        return new ResponseEntity<>(claims, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaimDTO> getClaimById(@PathVariable("id") Long id) {
        ClaimDTO claim = claimService.getClaimById(id);
        return new ResponseEntity<>(claim, HttpStatus.OK);
    }

    @PostMapping("/{policyNumber}")
    public ResponseEntity<ClaimDTO> createClaim(@RequestBody ClaimDTO claimDTO, @PathVariable("policyNumber") Long policyNumber) {
        ClaimDTO claim = claimService.createClaim(claimDTO, policyNumber);
        return new ResponseEntity<>(claim, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaimDTO> updateClaim(@PathVariable("id") Long id, @RequestBody  ClaimDTO claimDTO) {
        ClaimDTO claim = claimService.updateClaim(id, claimDTO);
        return new ResponseEntity<>(claim, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable("id") Long id) {
        claimService.deleteClaim(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

