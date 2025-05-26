package com.nn.rudra.repo.clientRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nn.rudra.entity.clientEntity.Client;

public interface ClientRepository extends JpaRepository<Client, String>{ 

}
