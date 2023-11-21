package com.administracion.controller;

import com.administracion.dto.TablaDto;
import com.administracion.service.TablaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tabla")
public class TablaController {

    @Autowired
    private TablaService tablaService;

    @GetMapping("/all")
    public ResponseEntity<?> listarTablas(){
        return new ResponseEntity<>(tablaService.obtenerTablas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTabla(@PathVariable("id") int id){
        TablaDto tabla = tablaService.obtenerTabla(id);
        if (tabla == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tabla, HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarTabla(@RequestBody TablaDto tablaDto) throws Exception {

        TablaDto tablaSaved = tablaService.guardarTabla(tablaDto);
        return new ResponseEntity<>(tablaSaved, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarTabla(@PathVariable("id") int id, @RequestBody TablaDto tablaDto) throws Exception {
        TablaDto tablaUpdated =  tablaService.editarTabla(id, tablaDto);
        if (tablaUpdated == null){
            return new ResponseEntity<>("La opcion que desea editar no existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tablaUpdated, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarTabla(@PathVariable("id") int id) throws Exception {
        boolean tablaDeleted =  tablaService.eliminarTabla(id);
        if (tablaDeleted){
            return new ResponseEntity<>("Tabla eliminada satisfactoriamente", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("La tabla no existe", HttpStatus.NOT_FOUND);
    }
}
