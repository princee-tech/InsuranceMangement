package com.INSURANCE.Repository;



import com.INSURANCE.Entities.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy,Long> {
        }
