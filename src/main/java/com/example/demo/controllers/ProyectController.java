package com.example.demo.controllers;


import com.example.demo.model.Project;
import com.example.demo.model.Role;
import com.example.demo.services.ProyectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProyectController {

    @Autowired
    ProyectService proyectService;

    @GetMapping()
    public ArrayList<Project> obtenerProyecto(){
        return proyectService.obtenerProyecto();
    }

    @PostMapping()
    public Project guardarRol(@RequestBody Project project){
        return this.proyectService.guardarProyecto(project);
    }

    @GetMapping( path = "/{id}")
    public Optional<Project> obtenerProyectoPorId(@PathVariable("id") Long id) {
        return this.proyectService.obtenerProyectoPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarProyectoPorID(@PathVariable("id") Long id){
        boolean ok = this.proyectService.eliminarProyecto(id);
        if (ok){
            return "Se eliminó el Proyecto con id " + id;
        }else{
            return "No pudo eliminar el Proyecto con id" + id;
        }
    }

}
