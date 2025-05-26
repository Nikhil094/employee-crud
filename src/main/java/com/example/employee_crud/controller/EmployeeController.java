package com.example.employee_crud.controller;

import com.example.employee_crud.model.Employee;
import com.example.employee_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Employee emp) {
        service.create(emp);
        return ResponseEntity.ok("Employee added successfully");
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        Employee emp = service.getById(id);
        if (emp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(emp);
    }

   @PutMapping("/{id}")
public ResponseEntity<String> update(@PathVariable int id, @RequestBody Employee emp) {
    Employee existing = service.getById(id);
    if (existing == null) {
        return ResponseEntity.notFound().build();
    }
    emp.setId(id);  // Ensure the ID in the employee object matches path variable
    service.update(emp);
    return ResponseEntity.ok("Employee updated successfully");
}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        if (service.getById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
