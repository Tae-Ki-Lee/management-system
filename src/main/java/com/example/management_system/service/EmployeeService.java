package com.example.management_system.service;

import com.example.management_system.model.Employee;
import com.example.management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // 모든 직원 조회
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // 직원 추가
    public Employee addEmployee(String name, int age, double hourlyWage, String location) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        employee.setHourlyWage(hourlyWage);
        employee.setLocation(location);
        employee.setWorkingHours(0);  // 초기 근무 시간은 0으로 설정
        return employeeRepository.save(employee);
    }

    // 직원 삭제
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    // 특정 직원 조회
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    // 저장 메서드
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}