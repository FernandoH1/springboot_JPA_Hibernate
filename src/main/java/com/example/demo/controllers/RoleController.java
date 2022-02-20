package com.example.demo.controllers;


import com.example.demo.model.Employee;
import com.example.demo.model.Role;
import com.example.demo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping()
    public ArrayList<Role> obtenerRol(){
        return roleService.obtenerRol();
    }

    @PostMapping()
    public Role guardarRol(@RequestBody Role role){
        return this.roleService.guardarRol(role);
    }

    @GetMapping( path = "/{id}")
    public Optional<Role> obtenerRolPorId(@PathVariable("id") Long id) {
        return this.roleService.obtenerRolPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarRolPorID(@PathVariable("id") Long id){
        boolean ok = this.roleService.eliminarRole(id);
        if (ok){
            return "Se eliminó el Rol con id " + id;
        }else{
            return "No pudo eliminar el Rol con id" + id;
        }
    }

    @PutMapping( path = "/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable("id") long id, @RequestBody Role role) {
        return this.roleService.updateRole(id,role);
    }
}
