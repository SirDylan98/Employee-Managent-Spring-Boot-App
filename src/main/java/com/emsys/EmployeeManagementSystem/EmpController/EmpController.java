package com.emsys.EmployeeManagementSystem.EmpController;

import com.emsys.EmployeeManagementSystem.EmpModel.Employees;
import com.emsys.EmployeeManagementSystem.EmpService.EmployeesService;
import com.emsys.EmployeeManagementSystem.Exceptions.EmployeeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class EmpController {
    @Autowired
    private EmployeesService employeesService;
    @PostMapping("save")
    public ResponseEntity<Employees> saveUser (@RequestBody Employees employee){
        return ResponseEntity.ok().body(employeesService.saveEmp(employee));
    }
    @GetMapping("all")
    public ResponseEntity<List<Employees>> getAllEmployees()
    {
        return ResponseEntity.ok().body(employeesService.getAllEmp());
    }
    @GetMapping("emp/{id}")
    public ResponseEntity<Optional<?>> getEmployee(@PathVariable Long id){
        return  ResponseEntity.ok().body(employeesService.getById(id));
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable("id") Long id, @RequestBody Employees employee ) throws EmployeeNotFoundException {
        return ResponseEntity.ok().body(employeesService.updateEmployee(id,employee));
    }
}
