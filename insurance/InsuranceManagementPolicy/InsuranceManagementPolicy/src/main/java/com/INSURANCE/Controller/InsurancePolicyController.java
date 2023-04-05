package com.INSURANCE.Controller;


import com.INSURANCE.Payload.InsurancePolicyDTO;
import com.INSURANCE.Service.InsurancePolicyService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insurance-policies")
public class InsurancePolicyController{

    private final InsurancePolicyService insurancePolicyService;

    public InsurancePolicyController(InsurancePolicyService insurancePolicyService) {
        this.insurancePolicyService= insurancePolicyService;
    }

    @GetMapping
    public List<InsurancePolicyDTO>getAllInsurancePolicies() {
        return insurancePolicyService.getAllInsurancePolicies();
    }

    @GetMapping("/{id}")
    public InsurancePolicyDTO getInsurancePolicyById(@PathVariable Long id) {
        return insurancePolicyService.getInsurancePolicyById(id);
    }

    @PostMapping("/{ClientId}")
    public InsurancePolicyDTO createInsurancePolicy(@RequestBody InsurancePolicyDTO insurancePolicyDTO,@PathVariable("ClientId") long ClientId) {
        return insurancePolicyService.createInsurancePolicy(insurancePolicyDTO,ClientId);
    }

    @PutMapping("/{id}")
    public InsurancePolicyDTO updateInsurancePolicy(@PathVariable Long id, @RequestBody InsurancePolicyDTO insurancePolicyDTO) {
        return insurancePolicyService.updateInsurancePolicy(id, insurancePolicyDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteInsurancePolicy(@PathVariable Long id) {
        insurancePolicyService.deleteInsurancePolicy(id);
    }
}
