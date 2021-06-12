
package com.example.ejemplo01.entity;
import javax.persistence.*;

/**
 *
 * @author sagov8
 */

@Entity
@Table(name = "producto")
public class Producto {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "precio")
    private float precio;
    @Column(name = "estado")
    private String estado;

    public Producto() {
    }
    
    public Producto(String nombre, int cantidad, float precio, String estado) {
        this.name = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estado = estado;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
