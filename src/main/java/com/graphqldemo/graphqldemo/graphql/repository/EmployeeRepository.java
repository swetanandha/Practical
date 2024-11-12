package com.graphqldemo.graphqldemo.graphql.repository;

import com.graphqldemo.graphqldemo.graphql.model.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom queries can be added if needed
}