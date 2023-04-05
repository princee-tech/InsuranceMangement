package com.INSURANCE.Repository;

import com.INSURANCE.Entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository  extends JpaRepository<Claim,Long> {
}
