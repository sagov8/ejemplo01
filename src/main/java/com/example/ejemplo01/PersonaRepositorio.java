
package com.example.ejemplo01;

import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author sagov8
 */
public interface PersonaRepositorio extends Repository<Persona, Integer>{
    List<Persona>findAll();
    Persona findOne(int id);
    Persona save(Persona p);
    
    
}
