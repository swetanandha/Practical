package com.graphqldemo.graphqldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.graphqldemo.graphqldemo.graphql.model.*;

import com.graphqldemo.graphqldemo.graphql.resolver.*;

@SpringBootApplication
public class GraphqldemoApplication {

	@Autowired
	static EmployeeResolver emp;
	
	public static void main(String[] args) {
		SpringApplication.run(GraphqldemoApplication.class, args);
//
		emp.addEmployee("sweta",25,"a",null,0.00);
		System.out.println("--------------------------------");
		System.out.print(emp.listEmployees(null, null, null));
		System.out.println("--------------------------------");
	}

}
