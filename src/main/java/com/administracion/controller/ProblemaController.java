package com.administracion.controller;

import com.administracion.dto.ProblemaDto;
import com.administracion.service.ProblemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/problema")
public class ProblemaController {

    @Autowired
    private ProblemaService problemaService;

    @GetMapping("/all")
    public ResponseEntity<?> listarProblemas(){
        return new ResponseEntity<>(problemaService.obtenerProblemas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProblema(@PathVariable("id") int id){
        ProblemaDto problema = problemaService.obtenerProblema(id);
        if (problema == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(problema, HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarProblema(@RequestBody ProblemaDto problemaDto) throws Exception {

        ProblemaDto problemaSaved = problemaService.guardarProblema(problemaDto);
        return new ResponseEntity<>(problemaSaved, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarProblema(@PathVariable("id") int id, @RequestBody ProblemaDto problemaDto) throws Exception {
        ProblemaDto problemaUpdated =  problemaService.editarProblema(id, problemaDto);
        if (problemaUpdated == null){
            return new ResponseEntity<>("La opcion que desea editar no existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(problemaUpdated, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarProblema(@PathVariable("id") int id) throws Exception {
        boolean problemaDeleted =  problemaService.eliminarProblema(id);
        if (problemaDeleted){
            return new ResponseEntity<>("Problema eliminado satisfactoriamente", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("El problema no existe", HttpStatus.NOT_FOUND);
    }
}
