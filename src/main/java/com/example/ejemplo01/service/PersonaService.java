package com.example.ejemplo01.service;

import com.example.ejemplo01.entity.Persona;
import com.example.ejemplo01.repository.PersonaRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sagov8
 */
@Service
@Transactional
public class PersonaService {

    @Autowired
    PersonaRepositorio personaRepository;

    public List<Persona> list() {
        return personaRepository.findAll();
    }

    public Optional<Persona> getById(int id) {
        return personaRepository.findById(id);
    }

    public Optional<Persona> getbyName(String nombre) {
        return personaRepository.findByName(nombre);
    }
    
    public Optional<Persona> getbyApellidos(String nombre) {
        return personaRepository.findByApellidos(nombre);
    }

    public void save(Persona persona) {
        personaRepository.save(persona);
    }

    public void delete(int id) {
        personaRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return personaRepository.existsById(id);
    }
    
    public boolean existsByName(String nombre) {
        return personaRepository.existsByName(nombre);
    }
    
    public boolean existsByApellidos(String nombre) {
        return personaRepository.existsByApellidos(nombre);
    }

    public List<Persona> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
