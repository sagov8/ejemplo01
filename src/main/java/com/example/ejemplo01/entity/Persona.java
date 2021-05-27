
package com.example.ejemplo01.entity;
import javax.persistence.*;

/**
 *
 * @author sagov8
 */

@Entity
@Table(name = "personas")
public class Persona{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "apellidos")
    private String apellidos;

    public Persona() {
    }
    
    public Persona(String nombre, String apellidos) {
        this.name = nombre;
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
