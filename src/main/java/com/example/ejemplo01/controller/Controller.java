package com.example.ejemplo01.controller;

import com.example.ejemplo01.dto.Mensaje;
import com.example.ejemplo01.service.PersonaService;
import com.example.ejemplo01.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sagov8
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/personas"})
public class Controller {

    @Autowired
    PersonaService service;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = service.getOne(id).get();
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{name}")
    public ResponseEntity<Persona> getByName(@PathVariable("name")String name){
        if(!service.existsByName(name))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = service.getbyName(name).get();
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
}
