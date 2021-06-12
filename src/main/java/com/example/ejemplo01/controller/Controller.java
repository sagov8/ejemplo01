package com.example.ejemplo01.controller;
import com.example.ejemplo01.dto.Mensaje;
import com.example.ejemplo01.dto.ProductoDto;
import com.example.ejemplo01.service.ProductoService;
import com.example.ejemplo01.entity.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sagov8
 */
@CrossOrigin(origins = "postgres://exfwanuijiatlm:dba855497592b1f25803103596522dd7f5f6a303f2dff294c62934de5ca60899@ec2-52-5-247-46.compute-1.amazonaws.com:5432/d8q6blp3ch5l6p")
@RestController
@RequestMapping({"/producto"})
public class Controller {

    @Autowired
    ProductoService productoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Producto>> list() {
        List<Producto> list = productoService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id")int id){
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Producto producto = productoService.listarId(id);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }
    
    @GetMapping("/detailname/{name}")
    public ResponseEntity<Producto> getByName(@PathVariable("name")String name){
        if(!productoService.existsByName(name))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Producto producto = productoService.getByName(name).get();
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> Create(@RequestBody Producto producto){
        if(StringUtils.isBlank(producto.getName()))
            return new ResponseEntity<>(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(String.valueOf(producto.getCantidad())))
            return new ResponseEntity<>(new Mensaje("campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(productoService.existsByName(producto.getName()))
            return new ResponseEntity<>(new Mensaje("Nombre ya registrado"), HttpStatus.BAD_REQUEST);
        Producto product = new Producto(producto.getName(), producto.getCantidad(),
                producto.getPrecio(), producto.getEstado());
        verificarEstado(product);
        productoService.save(product);
        return new ResponseEntity<>(new Mensaje("El producto ha sido agregado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProductoDto productoDto){
        if(!productoService.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(productoService.existsByName(productoDto.getName()) && productoService.getByName(productoDto.getName()).get().getId() != id)
            return new ResponseEntity<>(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(productoDto.getName()))
            return new ResponseEntity<>(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Producto producto = productoService.listarId(id);
        producto.setName(productoDto.getName());
        producto.setCantidad(productoDto.getCantidad());
        producto.setPrecio(productoDto.getPrecio());
        verificarEstado(producto);
        productoService.save(producto);
        return new ResponseEntity<>(new Mensaje("Se han actualizado los datos"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Producto> delete(@PathVariable("id")int id){
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        productoService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    public void verificarEstado(Producto producto){
        if (producto.getCantidad() > 0) {
            producto.setEstado("Disponible");
        } else {
            producto.setEstado("Agotado");
        }
    }
}
