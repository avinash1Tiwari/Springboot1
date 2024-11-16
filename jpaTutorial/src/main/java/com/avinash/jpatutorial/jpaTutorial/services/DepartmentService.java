package com.avinash.jpatutorial.jpaTutorial.services;

import com.avinash.jpatutorial.jpaTutorial.Repositories.DepartmentRepository;
import com.avinash.jpatutorial.jpaTutorial.Repositories.EmployeeRepository;
import com.avinash.jpatutorial.jpaTutorial.dto.DepartmentDto;
import com.avinash.jpatutorial.jpaTutorial.entities.DepartMent;
import com.avinash.jpatutorial.jpaTutorial.entities.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;


    public DepartmentService(DepartmentRepository departmentRepository,EmployeeRepository employeeRepository)
    {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public Optional<DepartMent> getDepartmentById(Long id)
    {
        return departmentRepository.findById(id);
    }

    public DepartMent createDepartment(DepartmentDto departmentDto)
    {
        DepartMent department = new DepartMent();
        department.setTitle(departmentDto.getTitle());


        EmployeeEntity manager = employeeRepository.findByName(departmentDto.getManager());



        department.setManager(manager);

        return departmentRepository.save(department);
    }

    public DepartMent assignManagerToDepartment(Long deptId,Long maagerId)
    {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(maagerId);
        Optional<DepartMent> departMent = departmentRepository.findById(deptId);

        return departMent.flatMap(depart ->
                employeeEntity.map(employee ->{
                    depart.setManager(employee);
                    return departmentRepository.save(depart);
                })

                ).orElse(null);
    }

    public List<DepartMent> getAllDepartment()
    {
        return departmentRepository.findAll();
    }

    public DepartMent getDepartmentByName(String name) {
        return departmentRepository.getDepartmentByName(name);
    }

    public DepartMent assignWorkerToDepartment(Long deptId, Long workerId) {

        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(workerId);
        Optional<DepartMent> departMent = departmentRepository.findById(deptId);

        return departMent.flatMap(depart ->
                employeeEntity.map(employee ->{

                    employee.setWorkerDepartment(depart);
                    employeeRepository.save(employee);
                    depart.getWorkers().add(employee);
                    return depart;
                })

        ).orElse(null);
    }
}
