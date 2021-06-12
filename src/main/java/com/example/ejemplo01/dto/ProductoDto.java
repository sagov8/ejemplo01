
package com.example.ejemplo01.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author sagov8
 */
public class ProductoDto {

    @NotBlank
    private String name;
    @Min(0)
    private int cantidad;
    @Min(0)
    private float precio;
    @NotBlank
    private String estado;

    public ProductoDto() {
    }

    public ProductoDto(@NotBlank String name, @Min(0) int cantidad,
                       @Min(0) float precio, @NotBlank String estado) {
        this.name = name;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estado = estado;
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
