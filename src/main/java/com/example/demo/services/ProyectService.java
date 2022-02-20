package com.example.demo.services;

import com.example.demo.model.Project;
import com.example.demo.model.Role;
import com.example.demo.repository.IProjectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<Project> updateProject(long id,Project Project) {
        Optional<Project> ProjectData = projectJpaRepository.findById(id);

        if (ProjectData.isPresent()) {
            Project _project = ProjectData.get();
            _project.setName(Project.getName());
            return new ResponseEntity<>(projectJpaRepository.save(_project), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
