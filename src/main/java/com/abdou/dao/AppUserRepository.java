package com.abdou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.abdou.entities.AppRole;
import com.abdou.entities.AppUser;
@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<AppUser , Long>{

	public AppUser findByUsername(String username);

}
