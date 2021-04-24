package com.abdou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.abdou.entities.Tasks;
@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Tasks, Long>{

}
