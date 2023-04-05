package com.INSURANCE.Repository;

import com.INSURANCE.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
        }

