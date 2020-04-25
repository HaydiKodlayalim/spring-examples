package com.haydikodlayalim.webflux.repo;

import com.haydikodlayalim.webflux.entity.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
}
