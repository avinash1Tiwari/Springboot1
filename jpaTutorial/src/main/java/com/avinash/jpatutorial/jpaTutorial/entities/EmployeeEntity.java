package com.avinash.jpatutorial.jpaTutorial.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "manager")
    @JsonIgnore                           // to stop reccursive call while fetching data by  departmentById Api
    private DepartMent departmentManaged;


    @ManyToOne
    @JoinColumn(name = "worker_department_id",referencedColumnName = "id")
    private DepartMent workerDepartment;

}
