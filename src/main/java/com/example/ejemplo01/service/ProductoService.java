package com.example.ejemplo01.service;

import com.example.ejemplo01.entity.Producto;
import com.example.ejemplo01.repository.ProductoRepositorio;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sagov8
 */
@Service
@Transactional
public class ProductoService {

    @Autowired
    ProductoRepositorio productoRepositorio;

    public List<Producto> list() {
        return productoRepositorio.findAll();
    }

    public Producto listarId(int id) {
        return productoRepositorio.findById(id);
    }

    public Optional<Producto> getByName(String name) {
        return productoRepositorio.findByName(name);
    }

    public void save(Producto producto) {
        productoRepositorio.save(producto);
    }

    public void delete(int id) {
        productoRepositorio.deleteById(id);
    }

    public boolean existsById(int id) {
        return productoRepositorio.existsById(id);
    }

    public boolean existsByName(String name) {
        return productoRepositorio.existsByName(name);
    }

}
