//package com.springCrud.example.SpringCrudOperations.dto;
//
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDate;
//
//import java.time.LocalDate;
//
//public class Employeedto {
//
//
//    @Setter
//    @Getter
//    private Long empId;
//
//    @Setter
//    @Getter
//    private String name;
//    @Setter
//    @Getter
//    private String email;
//    @Getter
//    private LocalDate dateOfJoining;
//    private boolean isActive;
//
//    public Employeedto() {
//    }
//    public Employeedto(Long empId, String name, String email, LocalDate dateOfJoining, boolean isActive)
//    {
//        this.empId = empId;
//        this.name = name;
//        this.email = email;
//        this.dateOfJoining = dateOfJoining;
//        this.isActive = isActive;
//    }
//
//    public void setActive(boolean active) {
//        isActive = active;
//    }
//
//    public void setDateOfJoining(LocalDate dateOfJoining) {
//        this.dateOfJoining =  dateOfJoining;
//    }
//
//    public boolean getStatus()
//    {
//        return this.isActive;
//    }
//
//
//
//
//    @Override
//    public String toString() {
//        return "Employeedto{" +
//                "id=" + empId +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", dateOfJoining=" + dateOfJoining +
//                '}';
//    }
//}
//
//
//
//
//
//
//
package com.springCrud.example.SpringCrudOperations.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springCrud.example.SpringCrudOperations.annotations.EmployeeValidation;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Employeedto {



    private Long empId;

//    @NotNull(message = "Required field in Employee : name")       // to ensure "name" field is present in request-body.
//    @NotEmpty(message = "Name of employee can not empty ")                         // to ensure the field(name) passed in request-body is not empty.

    @NotBlank(message = "Name of employee can not empty ,(trimmed-length > 0)")
    @Size(min=3,max=10, message = "Number of characters in the name should be in range : [3,10]")
    private String name;

    @Email(message = "email should be a valid email")
    private String email;

    @PastOrPresent(message = "Joining date can not be in future")
    private LocalDate dateOfJoining;


   @NotEmpty(message = "role can not be empty")
//   @Pattern(regexp = "^(ADMIN|USER)$" , message = "role can either be USER or ADMIN")//    provided by Springboot

   @EmployeeValidation      //// it's my custom Annotation
    private String role;

   @Positive(message = "salary should be greater than zero")
    private Integer salary;

   @Range(min = 18,max=80, message = "age should be range :[18,80]")
    private Integer age;

   @Min(value = 30,message = "Probation period must be greater than 30")
   @Max(value = 90,message = "Probation period must be less than 90")
   private Integer probationPeriod;


    @JsonProperty("isActive")
    private boolean isActive;



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







