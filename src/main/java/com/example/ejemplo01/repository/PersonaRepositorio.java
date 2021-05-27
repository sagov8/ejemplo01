
package com.example.ejemplo01.repository;

import com.example.ejemplo01.entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sagov8
 */
@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer>{
    
    Optional<Persona> findById(int id);
    boolean existsById(int id);
    Optional<Persona> findByName(String nombre);
    boolean existsByName(String nombre);
    Optional<Persona> findByApellidos(String nombre);
    boolean existsByApellidos(String nombre);
    
}
