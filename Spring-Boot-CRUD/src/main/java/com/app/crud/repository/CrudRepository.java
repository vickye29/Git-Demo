package com.app.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.crud.model.Employee;

@Repository
public interface CrudRepository extends JpaRepository<Employee, Integer> {

}
