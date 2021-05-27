
package com.example.ejemplo01;

import java.util.List;

/**
 *
 * @author sagov8
 */
public interface PersonaService {
    List<Persona>listar();
    Persona listarID(int id);
    Persona add(Persona p);
    Persona edit(Persona p);
    Persona delete(int id);
}
