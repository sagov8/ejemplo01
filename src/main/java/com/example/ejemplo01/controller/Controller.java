package com.example.ejemplo01.controller;
import com.example.ejemplo01.dto.Mensaje;
import com.example.ejemplo01.dto.PersonaDto;
import com.example.ejemplo01.service.PersonaService;
import com.example.ejemplo01.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.commons.lang3.StringUtils;
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
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/personas"})
public class Controller {

    @Autowired
    PersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.listarId(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
    
    @GetMapping("/detailname/{name}")
    public ResponseEntity<Persona> getByName(@PathVariable("name")String name){
        if(!personaService.existsByName(name))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getByName(name).get();
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> Create(@RequestBody Persona persona){
        if(StringUtils.isBlank(persona.getName()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(persona.getApellidos()))
            return new ResponseEntity(new Mensaje("el apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        if(personaService.existsByName(persona.getName()))
            return new ResponseEntity(new Mensaje("Nombre ya registrado"), HttpStatus.BAD_REQUEST);
        Persona person = new Persona(persona.getName(), persona.getApellidos());
        personaService.save(person);
        return new ResponseEntity(new Mensaje("La persona ha sido agregada"), HttpStatus.OK);
    }  
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody PersonaDto personaDto){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(personaService.existsByName(personaDto.getName()) && personaService.getByName(personaDto.getName()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getName()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Persona persona = personaService.listarId(id);
        persona.setName(personaDto.getName());
        persona.setApellidos(personaDto.getApellidos());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Se han actualizado los datos"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Persona> delete(@PathVariable("id")int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("persona eliminada"), HttpStatus.OK);
    }
            
}
