package com.INSURANCE.Payload;

import com.INSURANCE.Entities.InsurancePolicy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClaimDTO {

    private Long id;
    private String claimNumber;
    private String description;
    private Date claimDate;
    private String claimStatus;
    private InsurancePolicy insurancePolicy;

}



