package com.bridgelabz.GlobalEmployee.repo;

import com.bridgelabz.GlobalEmployee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer>
{

}
