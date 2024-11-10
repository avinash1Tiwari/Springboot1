package com.avinash.jpatutorial.jpaTutorial.controller;


import com.avinash.jpatutorial.jpaTutorial.dto.DepartmentDto;
import com.avinash.jpatutorial.jpaTutorial.entities.DepartMent;
import com.avinash.jpatutorial.jpaTutorial.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{deptId}")
    public Optional<DepartMent> getEmployeeById(@PathVariable Long deptId)
    {
        return departmentService.getDepartmentById(deptId);
    }

    @PostMapping(path = "/createdept")
    public ResponseEntity<DepartMent> createDepartment(@RequestBody DepartmentDto departmentDto)
    {
        DepartMent department = departmentService.createDepartment(departmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(department);
    }

    @GetMapping(path = "/alldept")
    public List<DepartMent> getAllDepartment()
    {
        return departmentService.getAllDepartment();
    }

    @GetMapping(path = "deptbyname")
    public DepartMent getDeptByName(@RequestParam String name)
    {
        return departmentService.getDepartmentByName(name);
    }

    @PutMapping(path = "{deptId}/assigmanger/{managerId}")
    public DepartMent assignManagerToDepartment(@PathVariable Long deptId,@PathVariable Long managerId)
    {
        return departmentService.assignManagerToDepartment(deptId,managerId);
    }


    @PutMapping(path = "{deptId}/assignworker/{workerId}")
    public DepartMent assignWorkerToDepartment(@PathVariable Long deptId,@PathVariable Long workerId)
    {
        return departmentService.assignWorkerToDepartment(deptId,workerId);
    }


}
