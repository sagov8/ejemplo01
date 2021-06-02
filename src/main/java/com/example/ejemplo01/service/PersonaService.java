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
    
    public Persona listarId(int id){
        return personaRepository.findById(id);
        
    }
    
    public Optional<Persona> getByName(String name) {
        return personaRepository.findByName(name);
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
    
    public boolean existsByName(String name) {
        return personaRepository.existsByName(name);
    }
    
}
