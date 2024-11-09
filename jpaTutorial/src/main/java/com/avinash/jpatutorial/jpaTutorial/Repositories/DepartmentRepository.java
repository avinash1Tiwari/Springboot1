package com.avinash.jpatutorial.jpaTutorial.Repositories;

import com.avinash.jpatutorial.jpaTutorial.entities.DepartMent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<DepartMent,Long> {

    @Query("select d from DepartMent d where d.title = :name")
     DepartMent getDepartmentByName(String name);
}
