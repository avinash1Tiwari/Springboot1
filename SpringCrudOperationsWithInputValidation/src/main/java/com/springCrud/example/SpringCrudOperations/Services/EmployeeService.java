////1 . returning directly Entity(employeeEntity) to controller , which is incorrect
//
//
//
////package com.springCrud.example.SpringCrudOperations.Services;
////
////import com.springCrud.example.SpringCrudOperations.Entities.EmployeeEntity;
////import com.springCrud.example.SpringCrudOperations.Repositories.EmployeeRepository;
////import org.springframework.stereotype.Service;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.PathVariable;
////import org.springframework.web.bind.annotation.PostMapping;
////
////import java.util.List;
////
////@Service
////public class EmployeeService {
////
////    private final EmployeeRepository empRepo;
////
////    public EmployeeService(EmployeeRepository empRepo)
////    {
////        this.empRepo = empRepo;
////    }
////
////
////    public List<EmployeeEntity> getAllEmployee()
////    {
////        return empRepo.findAll();
////    }
////
////
////    public EmployeeEntity getOneEmployee(Long id)
////    {
////        return empRepo.findById(id).orElse(null);
////    }
////
////    public EmployeeEntity createEmployee(EmployeeEntity inputEmp)
////    {
////        return empRepo.save(inputEmp);
////    }
////}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////2. with the help of ModelMapper, we can convert Entity to DTO and can return it to controller as recommended too
//
//package com.springCrud.example.SpringCrudOperations.Services;
//
//import com.springCrud.example.SpringCrudOperations.Entities.EmployeeEntity;
//import com.springCrud.example.SpringCrudOperations.Repositories.EmployeeRepository;
//import com.springCrud.example.SpringCrudOperations.dto.Employeedto;
//import org.modelmapper.ModelMapper;
//import org.springframework.data.util.ReflectionUtils;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.lang.reflect.Field;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Service
//public class EmployeeService {
//
//    private final EmployeeRepository empRepo;
//
//    private final ModelMapper modelmapper;
//    public EmployeeService(EmployeeRepository empRepo,ModelMapper modelmapper)
//    {
//        this.modelmapper = modelmapper;
//        this.empRepo = empRepo;
//    }
//
//
//    public List<Employeedto> getAllEmployee()
//    {
//        List<EmployeeEntity> allEmpEntities = empRepo.findAll();
//
//        return allEmpEntities
//                .stream()
//                .map(employeeEntity -> modelmapper.map(employeeEntity,Employeedto.class))
//                .collect(Collectors.toList());
//
//
//    }
//
//
//    public Employeedto getOneEmployee(Long id)
//    {
//        EmployeeEntity empEntity =  empRepo.findById(id).orElse(null);
//         return modelmapper.map(empEntity,Employeedto.class);
//    }
//
//
//
//    public ResponseEntity<?> createEmployee(Employeedto inputEmpDto) {
//        try {
//            // Convert DTO to Entity
//            EmployeeEntity toSaveEntity = modelmapper.map(inputEmpDto, EmployeeEntity.class);
//
//            // Save the entity to the database
//            EmployeeEntity savedEntity = empRepo.save(toSaveEntity);
//
//            // Convert saved Entity back to DTO
//            Employeedto savedEmpDto = modelmapper.map(savedEntity, Employeedto.class);
//
//            // Return a success response with created status
//            return ResponseEntity.status(HttpStatus.CREATED).body(savedEmpDto);
//        } catch (Exception e) {
//            // Log the error and return a proper error response
//            System.err.println("Error occurred in the service layer: " + e.getMessage());
//
//            // Returning a JSON formatted error response
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("{\"error\": \"Error creating employee\", \"details\": \"" + e.getMessage() + "\"}");
//        }
//    }
//
//
//
//
//
////   update
//    public Employeedto updateEmpById(@RequestBody Employeedto inputEmp , Long empId)
//    {
//        EmployeeEntity empEntity = modelmapper.map(inputEmp,EmployeeEntity.class);
//
//        empEntity.setId(empId);
//        EmployeeEntity savedEmp = empRepo.save(empEntity);
//        return modelmapper.map(savedEmp,Employeedto.class);
//
////        checking
//
//    }
//
////delete
//    public String deleteById(Long empid)
//    {
//        System.out.println("Received empid: " + empid);
//        System.out.println("=========================entered in serviceeeee=======================================");
//        boolean isFound = empRepo.existsById(empid);
//
//        System.out.println(("isfound  : " + isFound));
//        if(!isFound)
//        {
//            return "Employee with given empId is not found";
//        }
//
//        empRepo.deleteById(empid);
//        return "Employee deleted successfully";
//    }
//
//
//
//    public boolean isEmployeeExisting(Long empId)
//    {
//        return empRepo.existsById(empId);
//    }
//
//    public Employeedto updateFieldById(Long empid, Map<String, Object> updates) {
//
//        boolean exists = isEmployeeExisting((empid));
//        if(!exists) return null;
//
////        EmployeeEntity employeeEntity = empRepo.findById(empid).get();
//        EmployeeEntity empEntity =  empRepo.findById(empid).orElse(null);
//        System.out.println("service = employeee : " + empEntity);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        updates.forEach((field,value) ->{
//            Field fieldTobeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class,field);
//            fieldTobeUpdated.setAccessible(true);
////            ReflectionUtils.setField(fieldTobeUpdated,empEntity,value);
//
//
//            if (field.equals("dateOfJoining") && value instanceof String) {
//                LocalDate dateValue = LocalDate.parse((String) value, formatter);
//                ReflectionUtils.setField(fieldTobeUpdated, empEntity, dateValue);
//            } else {
//                ReflectionUtils.setField(fieldTobeUpdated, empEntity, value);
//            }
//
//        });
//        return modelmapper.map(empRepo.save(empEntity), Employeedto.class);
//
//
//
//    }
//
//
//
//
//}


















//Best practise


//1 . returning directly Entity(employeeEntity) to controller , which is incorrect



//package com.springCrud.example.SpringCrudOperations.Services;
//
//import com.springCrud.example.SpringCrudOperations.Entities.EmployeeEntity;
//import com.springCrud.example.SpringCrudOperations.Repositories.EmployeeRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.List;
//
//@Service
//public class EmployeeService {
//
//    private final EmployeeRepository empRepo;
//
//    public EmployeeService(EmployeeRepository empRepo)
//    {
//        this.empRepo = empRepo;
//    }
//
//
//    public List<EmployeeEntity> getAllEmployee()
//    {
//        return empRepo.findAll();
//    }
//
//
//    public EmployeeEntity getOneEmployee(Long id)
//    {
//        return empRepo.findById(id).orElse(null);
//    }
//
//    public EmployeeEntity createEmployee(EmployeeEntity inputEmp)
//    {
//        return empRepo.save(inputEmp);
//    }
//}



















//2. with the help of ModelMapper, we can convert Entity to DTO and can return it to controller as recommended too

package com.springCrud.example.SpringCrudOperations.Services;

import com.springCrud.example.SpringCrudOperations.Entities.EmployeeEntity;
import com.springCrud.example.SpringCrudOperations.Repositories.EmployeeRepository;
import com.springCrud.example.SpringCrudOperations.dto.Employeedto;
import com.springCrud.example.SpringCrudOperations.exceptions.ResourceNotFoundException;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository empRepo;

    private final ModelMapper modelmapper;
    public EmployeeService(EmployeeRepository empRepo,ModelMapper modelmapper)
    {
        this.modelmapper = modelmapper;
        this.empRepo = empRepo;
    }


    public List<Employeedto> getAllEmployee()
    {
        List<EmployeeEntity> allEmpEntities = empRepo.findAll();

        return allEmpEntities
                .stream()
                .map(employeeEntity -> modelmapper.map(employeeEntity,Employeedto.class))
                .collect(Collectors.toList());


    }


    public Optional<Employeedto> getOneEmployee(Long id)
    {
        Optional<EmployeeEntity> empEntity =  empRepo.findById(id);
        return empEntity.map(empEntity1 -> modelmapper.map(empEntity1,Employeedto.class));
    }



    public ResponseEntity<?> createEmployee(Employeedto inputEmpDto) {
        try {
            // Convert DTO to Entity
            EmployeeEntity toSaveEntity = modelmapper.map(inputEmpDto, EmployeeEntity.class);

            // Save the entity to the database
            EmployeeEntity savedEntity = empRepo.save(toSaveEntity);

            // Convert saved Entity back to DTO
            Employeedto savedEmpDto = modelmapper.map(savedEntity, Employeedto.class);

            // Return a success response with created status
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEmpDto);
        } catch (Exception e) {
            // Log the error and return a proper error response
            System.err.println("Error occurred in the service layer: " + e.getMessage());

            // Returning a JSON formatted error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\": \"Error creating employee\", \"details\": \"" + e.getMessage() + "\"}");
        }
    }







    public Employeedto updateEmpById(Employeedto inputEmp, Long empId) {
        // Check if the employee with empId exists
        Optional<EmployeeEntity> existingEmpOpt = empRepo.findById(empId);

        if (existingEmpOpt.isEmpty()) {
            throw new ResourceNotFoundException("Employee with ID " + empId + " not found");
        }

        EmployeeEntity existingEmp = existingEmpOpt.get();

        // Configure ModelMapper to skip null fields
        modelmapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        // Map fields from input DTO to the existing employee entity, skipping null values
        modelmapper.map(inputEmp, existingEmp);

        // Save the updated entity to the database
        EmployeeEntity updatedEmp = empRepo.save(existingEmp);

        // Return the updated DTO
        return modelmapper.map(updatedEmp, Employeedto.class);
    }





    public boolean deleteById(Long empid) {
        System.out.println("Received empid: " + empid);
        System.out.println("=========================entered in service======================");

        boolean isFound = empRepo.existsById(empid);
        System.out.println("isFound: " + isFound);

        if (!isFound) {
            return false;  // Employee not found
        }

        empRepo.deleteById(empid);  // Delete the employee if found
        return true;  // Employee deleted successfully
    }

    public boolean isEmployeeExisting(Long empId)
    {
        return empRepo.existsById(empId);
    }

    public Employeedto updateFieldById(Long empid, Map<String, Object> updates) {

        boolean exists = isEmployeeExisting((empid));
        if(!exists) return null;

//        EmployeeEntity employeeEntity = empRepo.findById(empid).get();
        EmployeeEntity empEntity =  empRepo.findById(empid).orElse(null);
        System.out.println("service = employeee : " + empEntity);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        updates.forEach((field,value) ->{
            Field fieldTobeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class,field);
            fieldTobeUpdated.setAccessible(true);
//            ReflectionUtils.setField(fieldTobeUpdated,empEntity,value);


            if (field.equals("dateOfJoining") && value instanceof String) {
                LocalDate dateValue = LocalDate.parse((String) value, formatter);
                ReflectionUtils.setField(fieldTobeUpdated, empEntity, dateValue);
            } else {
                ReflectionUtils.setField(fieldTobeUpdated, empEntity, value);
            }

        });
        return modelmapper.map(empRepo.save(empEntity), Employeedto.class);



    }




}
