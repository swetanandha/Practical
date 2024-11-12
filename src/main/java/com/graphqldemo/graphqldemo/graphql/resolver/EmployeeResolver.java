package com.graphqldemo.graphqldemo.graphql.resolver;

import com.graphqldemo.graphqldemo.graphql.model.*;
import com.graphqldemo.graphqldemo.graphql.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeResolver {

    
    private EmployeeRepository employeeRepository = new EmpRepoImpl();

    @QueryMapping
    public List<Employee> listEmployees(@Argument String name, @Argument String employeeClass, @Argument Integer age) {
        // Implement filter logic here if necessary
        return employeeRepository.findAll();
    }

    @QueryMapping
    public Employee getEmployeeById(@Argument Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Employee> listEmployeesPaginated(@Argument int page, @Argument int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findAll(pageable).getContent();
    }

    @MutationMapping
    public Employee addEmployee(@Argument String name, @Argument int age, @Argument String employeeClass,
                                @Argument List<String> subjects, @Argument double attendance) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        employee.setEmployeeClass(employeeClass);
        employee.setSubjects(subjects);
        employee.setAttendance(attendance);
        return employeeRepository.save(employee);
    }

    @MutationMapping
    public Employee updateEmployee(@Argument Long id, @Argument String name, @Argument Integer age,
                                   @Argument String employeeClass, @Argument List<String> subjects,
                                   @Argument Double attendance) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            if (name != null) employee.setName(name);
            if (age != null) employee.setAge(age);
            if (employeeClass != null) employee.setEmployeeClass(employeeClass);
            if (subjects != null) employee.setSubjects(subjects);
            if (attendance != null) employee.setAttendance(attendance);
            return employeeRepository.save(employee);
        }
        return null;
    }
}