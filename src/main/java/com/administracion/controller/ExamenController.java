package com.administracion.controller;

import com.administracion.dto.ExamenDto;
import com.administracion.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/examen")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @GetMapping("/all")
    public ResponseEntity<?> listarExamenes(){
        return new ResponseEntity<>(examenService.obtenerExamenes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerExamen(@PathVariable("id") int id){
        ExamenDto examen = examenService.obtenerExamen(id);
        if (examen == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(examen, HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarExamen(@RequestBody ExamenDto examenDto) throws Exception {

        ExamenDto examenSaved = examenService.guardarExamen(examenDto);
        return new ResponseEntity<>(examenSaved, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarExamen(@PathVariable("id") int id, @RequestBody ExamenDto examenDto) throws Exception {
        ExamenDto examenUpdated =  examenService.editarExamen(id, examenDto);
        if (examenUpdated == null){
            return new ResponseEntity<>("La opcion que desea editar no existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(examenUpdated, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarExamen(@PathVariable("id") int id) throws Exception {
        boolean examenDeleted =  examenService.eliminarExamen(id);
        if (examenDeleted){
            return new ResponseEntity<>("Examen eliminado satisfactoriamente", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("El examen no existe", HttpStatus.NOT_FOUND);
    }

}
