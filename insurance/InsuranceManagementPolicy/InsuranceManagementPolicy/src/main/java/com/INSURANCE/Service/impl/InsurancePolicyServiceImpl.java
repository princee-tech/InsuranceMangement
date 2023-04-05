package com.INSURANCE.Service.impl;



import com.INSURANCE.Entities.Client;
import com.INSURANCE.Entities.InsurancePolicy;
import com.INSURANCE.Exception.ClientNotFound;
import com.INSURANCE.Exception.InsurancePolicyNotFound;

import com.INSURANCE.Payload.InsurancePolicyDTO;
import com.INSURANCE.Repository.ClientRepository;
import com.INSURANCE.Repository.InsurancePolicyRepository;
import com.INSURANCE.Service.InsurancePolicyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService{

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    @Autowired
    private ClientRepository clientRepository;

//    @Autowired
//    private ModelMappermodelMapper;

    @Override
    public List<InsurancePolicyDTO>getAllInsurancePolicies() {
        List<InsurancePolicy>insurancePolicies=insurancePolicyRepository.findAll();
        return insurancePolicies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public InsurancePolicyDTO getInsurancePolicyById(Long id) {
        InsurancePolicy insurancePolicy= insurancePolicyRepository.findById(id)
                .orElseThrow(() ->new InsurancePolicyNotFound("InsurancePolicy", "id", id));
        return convertToDto(insurancePolicy);
    }

    @Override
    public InsurancePolicyDTO createInsurancePolicy(InsurancePolicyDTO insurancePolicyDTO,Long ClientId) {

//        Client client1 = clientRepository.findById(ClientId).orElseThrow(() -> new ClientNotFound("Client", "Id", insurancePolicyDTO.getClient().getId()));
//        InsurancePolicy insurancePolicy1 = convertToEntity(insurancePolicyDTO);
//        insurancePolicy1.setClient(client1);

        Client client= clientRepository.findById(insurancePolicyDTO.getClient().getId())
                .orElseThrow(() ->new ClientNotFound("Client", "id", insurancePolicyDTO.getClient().getId(

                )));
        InsurancePolicy insurancePolicy= convertToEntity(insurancePolicyDTO);
        insurancePolicy.setClient(client);
        InsurancePolicy savedInsurancePolicy= insurancePolicyRepository.save(insurancePolicy);
        return convertToDto(savedInsurancePolicy);
    }

    @Override
    public InsurancePolicyDTO updateInsurancePolicy(Long id, InsurancePolicyDTO insurancePolicyDTO) {
        InsurancePolicy existingInsurancePolicy= insurancePolicyRepository.findById(id)
                .orElseThrow(() ->new InsurancePolicyNotFound("InsurancePolicy", "id", id));
        Client client= clientRepository.findById(insurancePolicyDTO.getClient().getId())
                .orElseThrow(() ->new ClientNotFound("Client", "id", insurancePolicyDTO.getClient().getId()));
        InsurancePolicy updatedInsurancePolicy= convertToEntity(insurancePolicyDTO);
        updatedInsurancePolicy.setId(existingInsurancePolicy.getId());
        updatedInsurancePolicy.setClient(client);
        InsurancePolicy savedInsurancePolicy= insurancePolicyRepository.save(updatedInsurancePolicy);
        return convertToDto(savedInsurancePolicy);
    }

    @Override
    public void deleteInsurancePolicy(Long id) {
        InsurancePolicy insurancePolicy= insurancePolicyRepository.findById(id)
                .orElseThrow(() ->new InsurancePolicyNotFound("InsurancePolicy", "id", id));
        insurancePolicyRepository.delete(insurancePolicy);
    }

    private InsurancePolicyDTO convertToDto(InsurancePolicy insurancePolicy) {
//        InsurancePolicyDTO insurancePolicyDTO = modelMapper.map(insurancePolicy, InsurancePolicyDTO.class);
//        insurancePolicyDTO.setClient(insurancePolicy.getClient());
//        return insurancePolicyDTO;
        InsurancePolicyDTO insurancePolicyDTO= new InsurancePolicyDTO();
        insurancePolicyDTO.setId(insurancePolicy.getId());
        insurancePolicyDTO.setPolicyNumber(insurancePolicy.getPolicyNumber());
        insurancePolicyDTO.setType(insurancePolicy.getType());
        insurancePolicyDTO.setCoverageAmount(insurancePolicy.getCoverageAmount());
        insurancePolicyDTO.setPremium(insurancePolicy.getPremium());
        insurancePolicyDTO.setStartDate(insurancePolicy.getStartDate());
        insurancePolicyDTO.setEndDate(insurancePolicy.getEndDate());
        return insurancePolicyDTO;

    }

    private InsurancePolicy convertToEntity(InsurancePolicyDTO insurancePolicyDTO) {
//        InsurancePolicy insurancePolicy = modelMapper.map(insurancePolicyDTO, InsurancePolicy.class);
//        return insurancePolicy;
        InsurancePolicy insurancePolicy= new InsurancePolicy();
        insurancePolicy.setPolicyNumber(insurancePolicyDTO.getPolicyNumber());
        insurancePolicy.setType(insurancePolicyDTO.getType());
        insurancePolicy.setCoverageAmount(insurancePolicyDTO.getCoverageAmount());
        insurancePolicy.setPremium(insurancePolicyDTO.getPremium());
        insurancePolicy.setStartDate(insurancePolicyDTO.getStartDate());
        insurancePolicy.setEndDate(insurancePolicyDTO.getEndDate());
        return insurancePolicy;

    }

}




