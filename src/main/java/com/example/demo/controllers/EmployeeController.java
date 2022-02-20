package com.example.demo.controllers;

import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public ArrayList<Employee> obtenerEmpledos(){
        return employeeService.obtenerEmpleados();
    }

    @PostMapping()
    public Employee guardarEmpleado(@RequestBody Employee employee){
        return this.employeeService.guardarEmpelado(employee);
    }

    @GetMapping( path = "/{id}")
    public Optional<Employee> obtenerEmpleadoPorId(@PathVariable("id") Long id) {
        return this.employeeService.obtenerPorID(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarEmpleadoPorID(@PathVariable("id") Long id){
        boolean ok = this.employeeService.eliminarEmpleado(id);
        if (ok){
            return "Se eliminó el Empleado con id " + id;
        }else{
            return "No pudo eliminar el Empleado con id" + id;
        }
    }

    @PutMapping( path = "/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        return this.employeeService.updateEmployee(id,employee);
    }


}
