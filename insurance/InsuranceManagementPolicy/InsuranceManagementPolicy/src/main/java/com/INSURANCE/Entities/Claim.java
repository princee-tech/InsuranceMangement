package com.INSURANCE.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="claim")
@Entity
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "claim_number")
    private String claimNumber;
    @Column(name = "description")
    private String description;
    @Column(name = "claim_date")
    private Date claimDate;
    @Column(name = "claim_status")
    private String claimStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id")
    private InsurancePolicy insurancePolicy;
    //constructors, getters and setters
}

