package com.abdou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.abdou.entities.Adress;

@RepositoryRestResource

public interface AdressRepository extends JpaRepository<Adress, Long> {

}
