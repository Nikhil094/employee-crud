package com.example.employee_crud.service;

import com.example.employee_crud.model.Employee;
import com.example.employee_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee getById(int id) {
        Optional<Employee> employee = repo.findById(id);
        return employee.orElse(null);
    }

    public Employee create(Employee emp) {
        return repo.save(emp);
    }

    public Employee update(Employee emp) {
        return repo.save(emp);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
