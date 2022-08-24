package com.likelion.jpadb.controller;

import com.likelion.jpadb.model.Department;
import com.likelion.jpadb.model.Employee;
import com.likelion.jpadb.repository.DepartmentRepository;
import com.likelion.jpadb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class APIController {
    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping(value = "/departments")
    public ResponseEntity<List<Department>> listDepartment(){
        List<Department> listDepartment = departmentRepository.findAll();
        return new ResponseEntity<List<Department>>(listDepartment, HttpStatus.OK);
    }

    @PostMapping(value = "/departments")
    public Department storeDepartment(@RequestBody Department department){
        return departmentRepository.save(department);
    }

    @GetMapping(value = "departments/{id}")
    public Optional<Department> showDepartment(@PathVariable("id") Long id){
        return departmentRepository.findById(id);
    }

    @PutMapping(value = "departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("id") Long id,
                                                       @RequestBody Department departmentInput){
        Department department = departmentRepository.getOne(id);
        if(department == null) {
            return ResponseEntity.notFound().build();
        }
        department.setDept_name(departmentInput.getDept_name());
        department.setDescription(departmentInput.getDescription());

        Department updatedDepartment = departmentRepository.save(department);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping(value = "departments/{id}")
    public ResponseEntity<Department> deleleDepartment(@PathVariable("id") Long id){
        Department department = departmentRepository.getReferenceById(id);
        if(department == null) {
            return ResponseEntity.notFound().build();
        }

        departmentRepository.delete(department);
        return ResponseEntity.ok().build();
    }

    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> listEmployee(){
        List<Employee> listEmployee = employeeRepository.findAll();
        return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);
    }

    @PostMapping(value = "/employees")
    public Employee storeEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping(value = "employees/{id}")
    public Optional<Employee> showEmployee(@PathVariable("id") Long id){
        return employeeRepository.findById(id);
    }

    @PutMapping(value = "employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,
                                                       @RequestBody Employee employeeInput){
        Employee employee = employeeRepository.getOne(id);
        if(employee == null) {
            return ResponseEntity.notFound().build();
        }
        employee.setName(employeeInput.getName());
        employee.setBirthDate(employeeInput.getBirthDate());
        employee.setDepartment(employeeInput.getDepartment());

        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping(value = "employees/{id}")
    public ResponseEntity<Employee> deleleEmployee(@PathVariable("id") Long id){
        Employee employee = employeeRepository.getReferenceById(id);
        if(employee == null) {
            return ResponseEntity.notFound().build();
        }

        employeeRepository.delete(employee);
        return ResponseEntity.ok().build();
    }
}
