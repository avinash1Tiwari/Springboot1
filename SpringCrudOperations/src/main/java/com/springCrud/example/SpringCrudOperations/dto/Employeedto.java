package com.springCrud.example.SpringCrudOperations.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import java.time.LocalDate;

public class Employeedto {


    @Setter
    @Getter
    private Long empId;

    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String email;
    @Getter
    private LocalDate dateOfJoining;
    private boolean isActive;

    public Employeedto() {
    }
    public Employeedto(Long empId, String name, String email, LocalDate dateOfJoining, boolean isActive)
    {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining =  dateOfJoining;
    }

    public boolean getStatus()
    {
        return this.isActive;
    }




    @Override
    public String toString() {
        return "Employeedto{" +
                "id=" + empId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }
}







