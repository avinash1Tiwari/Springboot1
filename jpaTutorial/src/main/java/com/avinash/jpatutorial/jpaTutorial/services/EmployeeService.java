package com.avinash.jpatutorial.jpaTutorial.services;

import com.avinash.jpatutorial.jpaTutorial.Repositories.EmployeeRepository;
import com.avinash.jpatutorial.jpaTutorial.entities.EmployeeEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity findByNmae(String name) {

        return employeeRepository.findByName(name);
    }

    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {

        return employeeRepository.save(employeeEntity);
    }
}
