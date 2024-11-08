package com.example.management_system.controller;

import com.example.management_system.model.Employee;
import com.example.management_system.model.Inventory;
import com.example.management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // 모든 직원 조회 (GET 요청)
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // 직원 추가 (POST 요청)
    @PostMapping
    public Employee addEmployee(@RequestParam String name, @RequestParam int age, @RequestParam double hourlyWage, @RequestParam String location) {
        return employeeService.addEmployee(name, age, hourlyWage, location);
    }

    // 특정 직원 삭제 (DELETE 요청)
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    // 특정 직원 조회 (GET 요청)
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Optional<Employee> tempEmployee = employeeService.getEmployeeById(id);
        if (tempEmployee.isPresent()) {
            Employee existingEmpolyee = tempEmployee.get();
            existingEmpolyee.setName(employee.getName());
            existingEmpolyee.setAge(employee.getAge());
            existingEmpolyee.setLocation(employee.getLocation());
            existingEmpolyee.setHourlyWage(employee.getHourlyWage());
            existingEmpolyee.setWorkingHours(employee.getWorkingHours());

            Employee updatedEmpolyee = employeeService.saveEmployee(existingEmpolyee);
            return ResponseEntity.ok(updatedEmpolyee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}