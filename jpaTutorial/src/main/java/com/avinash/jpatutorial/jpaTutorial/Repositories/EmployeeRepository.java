package com.avinash.jpatutorial.jpaTutorial.Repositories;

import com.avinash.jpatutorial.jpaTutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

    @Query("select e from EmployeeEntity e where e.name = :name")
      EmployeeEntity findByName(String name);
}
