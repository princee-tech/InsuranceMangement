package com.INSURANCE.Service;





import com.INSURANCE.Payload.InsurancePolicyDTO;
import java.util.List;

public interface InsurancePolicyService{

    List<InsurancePolicyDTO>getAllInsurancePolicies();
    InsurancePolicyDTO getInsurancePolicyById(Long id);
    InsurancePolicyDTO createInsurancePolicy(InsurancePolicyDTO insurancePolicyDTO,Long ClientId);
    InsurancePolicyDTO updateInsurancePolicy(Long id, InsurancePolicyDTO insurancePolicyDTO);
    void deleteInsurancePolicy(Long id);

}
