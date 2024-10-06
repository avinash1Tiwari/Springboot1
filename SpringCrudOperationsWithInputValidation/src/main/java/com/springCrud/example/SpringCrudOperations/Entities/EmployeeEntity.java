package com.springCrud.example.SpringCrudOperations.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Entity
@Getter
@Setter
@AllArgsConstructor  // Corrected annotation
@NoArgsConstructor
@Table(name = "SpringEmployee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;

    private String name;
    private String email;
    private LocalDate dateOfJoining;
    private String role;


    private Integer salary;


    private Integer age;


    private Integer probationPeriod;

    @JsonProperty("isActive")
    private boolean isActive;


    public void setId(Long empId) {
        this.empId=empId;
    }
}
