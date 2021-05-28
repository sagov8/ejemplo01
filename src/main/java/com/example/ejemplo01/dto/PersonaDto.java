
package com.example.ejemplo01.dto;

/**
 *
 * @author sagov8
 */
public class PersonaDto {
    
    private String name;
    private String apellidos;

    public PersonaDto() {
    }

    public PersonaDto(String name, String apellidos) {
        this.name = name;
        this.apellidos = apellidos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    
}
