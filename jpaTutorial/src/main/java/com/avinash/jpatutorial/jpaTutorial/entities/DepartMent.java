package com.avinash.jpatutorial.jpaTutorial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class DepartMent {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToOne
    @JoinColumn(name = "department_manager")      /// to give name of foreign-key , (but if this line is not written, hibernate byDefault provide a name suitably)
    private EmployeeEntity manager;

    @OneToMany(mappedBy = "workerDepartment", fetch = FetchType.EAGER)
    //3. fetch = FetchType.EAGER
    //Purpose: Specifies that the related entities should be loaded immediately with the parent entity.
    //Effect: When a Department entity is fetched, all associated Worker entities are also loaded at the same time.
    //Use Case: FetchType.EAGER is used when you need the related entities to be available immediately after the main entity is loaded. This can be useful when you know you’ll need the related entities and want to avoid additional database queries.
    //Note: Using EAGER can impact performance negatively if there are many associated entities, as it loads them all at once. It’s often better to use FetchType.LAZY when possible, which only loads the related entities when accessed.



    private Set<EmployeeEntity> workers;                        // this will not create a new-column, it is just for aknowledge department that it is connected to employeeEntity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartMent that = (DepartMent) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle());
    }
}
