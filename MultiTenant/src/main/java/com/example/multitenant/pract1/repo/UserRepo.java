package com.example.multitenant.pract1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.multitenant.pract1.model.Client;

public interface UserRepo extends JpaRepository<Client, Integer>{

}
