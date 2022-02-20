package com.example.demo.services;

import com.example.demo.model.Employee;
import com.example.demo.repository.IEmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
