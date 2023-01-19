package com.example.multitenant.pract.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.multitenant.pract.model.Client;

public interface ClientRepo extends JpaRepository<Client, Integer>{

}
