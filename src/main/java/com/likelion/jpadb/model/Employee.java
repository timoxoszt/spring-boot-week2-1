package com.likelion.jpadb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "employeeId", nullable = false)
    private Long employeeId;

    @Column(name = "name", length = 80, nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthDate", nullable = false)
    private Date birthDate;

    @Column(name = "gender", nullable = false)
    private boolean gender; // Male-1 Female-0

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
