package com.likelion.jpadb.model;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

import static org.hibernate.annotations.CascadeType.DELETE;

@Entity
@Table(name = "DEPARTMENT")
@Setter
@Getter
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "departmentId", nullable = false)
    private Long departmentId;

    @Column(name = "dept_name", length = 255, nullable = false)
    private String dept_name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "department")
    @Cascade(value = DELETE)
    private List<Employee> employees;
}
