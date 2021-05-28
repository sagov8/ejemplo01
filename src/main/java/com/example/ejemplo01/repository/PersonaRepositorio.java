
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
    
    Optional<Persona> findByName(String name);
    boolean existsByName(String name);
}
