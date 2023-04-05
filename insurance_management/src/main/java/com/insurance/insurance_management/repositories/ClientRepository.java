package com.insurance.insurance_management.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.insurance_management.entities.Client;

public interface ClientRepository extends JpaRepository <Client, Long> {

}
