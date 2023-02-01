package com.emsys.EmployeeManagementSystem.EmpRepo;

import com.emsys.EmployeeManagementSystem.EmpModel.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Long> {
}
