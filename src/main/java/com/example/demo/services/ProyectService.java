package com.example.demo.services;

import com.example.demo.model.Project;
import com.example.demo.repository.IProjectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProyectService {
    @Autowired
    IProjectJpaRepository projectJpaRepository;

    public ArrayList<Project> obtenerProyecto(){
        return (ArrayList<Project>) projectJpaRepository.findAll();
    }

    public Project guardarProyecto(Project project){
        return projectJpaRepository.save(project);
    }

    public Optional<Project> obtenerProyectoPorId(Long id){
        return projectJpaRepository.findById(id);
    }

    public boolean eliminarProyecto(Long id){
        try{
            projectJpaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
