package com.INSURANCE.Payload;


import com.INSURANCE.Entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InsurancePolicyDTO {
    private Long id;
    private String policyNumber;
    private String type;
    private double coverageAmount ;
    private double premium;
    private Date startDate;
    private Date endDate;
    private Client client;
}
