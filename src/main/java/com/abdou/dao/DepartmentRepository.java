package com.abdou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.abdou.entities.Department;

@RepositoryRestResource

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
