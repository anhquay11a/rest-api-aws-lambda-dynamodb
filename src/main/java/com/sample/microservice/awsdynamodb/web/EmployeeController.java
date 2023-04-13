package com.sample.microservice.awsdynamodb.web;


import com.sample.microservice.awsdynamodb.domain.Employee;
import com.sample.microservice.awsdynamodb.exception.DataNotFoundException;
import com.sample.microservice.awsdynamodb.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(value = "/employee")
    public List<Employee> all() {
        return employeeService.getAll();

    }

    @PostMapping(value = "/employee")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping(value = "/employee/{id}")
    public Employee update(@PathVariable("id") String id, @RequestBody Employee employee) {
        return employeeService.update(employee,id);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") String id) {
        return employeeService.getById(id).orElseThrow(() -> new DataNotFoundException("not found"));
    }
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable(value = "id") String id) {
        employeeService.delete(id);
    }

}
