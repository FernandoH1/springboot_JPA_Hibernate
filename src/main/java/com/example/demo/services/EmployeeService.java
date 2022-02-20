package com.example.demo.services;

import com.example.demo.model.Employee;
import com.example.demo.repository.IEmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeJpaRepository employeeJpaRepository;

    public ArrayList<Employee> obtenerEmpleados(){
        return (ArrayList<Employee>) employeeJpaRepository.findAll();
    }

    public Employee guardarEmpelado(Employee employee){
        return employeeJpaRepository.save(employee);
    }

    public Optional<Employee> obtenerPorID(Long id){
        return employeeJpaRepository.findById(id);
    }

    public boolean eliminarEmpleado(Long id){
        try{
            employeeJpaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public ResponseEntity<Employee> updateEmployee(Long id,Employee employee) {
        Optional<Employee> employeeData = employeeJpaRepository.findById(id);
        if (employeeData.isPresent()) {
            Employee _employee = employeeData.get();
            _employee.setFirstName(employee.getFirstName());
            _employee.setLastName(employee.getLastName());
            _employee.setEmployeeid(employee.getEmployeeid());
            _employee.setRole(employee.getRole());
            return new ResponseEntity<>(employeeJpaRepository.save(_employee), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
