package com.avinash.jpatutorial.jpaTutorial.controller;

import com.avinash.jpatutorial.jpaTutorial.entities.EmployeeEntity;
import com.avinash.jpatutorial.jpaTutorial.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/getbyname")
    public EmployeeEntity getEmployeeByName(@RequestParam String name)
    {
        return employeeService.findByNmae(name);
    }

    @PostMapping(path = "/create")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeEntity)
    {
        return employeeService.createEmployee(employeeEntity);
    }

    @GetMapping(path = "/getall")
    public List<EmployeeEntity> getAllEmployee()
    {
        return employeeService.getAllEmployee();
    }
}
