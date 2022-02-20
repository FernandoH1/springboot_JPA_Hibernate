package com.example.demo.services;

import com.example.demo.model.Role;
import com.example.demo.repository.IRoleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    IRoleJpaRepository roleJpaRepository;

    public ArrayList<Role> obtenerRol(){
        return (ArrayList<Role>) roleJpaRepository.findAll();
    }

    public Role guardarRol(Role role){
        return roleJpaRepository.save(role);
    }

    public Optional<Role> obtenerRolPorId(Long id){
        return roleJpaRepository.findById(id);
    }

    public boolean eliminarRole(Long id){
        try{
            roleJpaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
