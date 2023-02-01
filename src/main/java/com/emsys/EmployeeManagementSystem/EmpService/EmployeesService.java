package com.emsys.EmployeeManagementSystem.EmpService;

import com.emsys.EmployeeManagementSystem.EmpModel.Employees;
import com.emsys.EmployeeManagementSystem.EmpRepo.EmployeesRepository;
import com.emsys.EmployeeManagementSystem.Exceptions.EmployeeNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class EmployeesService {
    @Autowired
    private EmployeesRepository employeesRepository;

    public Employees saveEmp (Employees employee){
        log.info("THE EMPLOYEE HAS BEEN SAVED");
        return employeesRepository.save(employee);
    }
    public List<Employees> getAllEmp(){
        log.info("GETTING ALL THE EMPLOYEES");
        return employeesRepository.findAll();
    }
    public Optional <Employees> getById(Long id)throws EmployeeNotFoundException{
        Optional<Employees> employees=employeesRepository.findById(id);
        if(employees.isEmpty()){
            throw new EmployeeNotFoundException("There is no Employ with the Specified ID");
        }
        log.info("THE EMPLOYEE HAS BEEN FOUND");

        return employees;
    }

    public  Employees updateEmployee(Long id, Employees employee) throws EmployeeNotFoundException {
        // first we get the employee
        Employees employeeFound=employeesRepository.findById(id).get();
        if(employeeFound!=null){
            employeeFound.setFirstName(employee.getFirstName());
            employeeFound.setLastName(employee.getLastName());
            employeeFound.setEmail(employee.getEmail());
            log.info("THE DOCUMENT HAS BEEN UPDATED SUCCESSFULLY");
        }else {
            throw  new EmployeeNotFoundException("There is no Employ with the Specified ID");
        }

        return  employeesRepository.save(employeeFound);
    }
    public void deleteEmp(Long id){

        employeesRepository.deleteById(id);
        log.info("THE EMPLOYEE HAS BEEN DELETE");
    }
}
