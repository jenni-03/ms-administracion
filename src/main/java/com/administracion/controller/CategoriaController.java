package com.administracion.controller;

import com.administracion.dto.CategoriaDto;
import com.administracion.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/all")
    public ResponseEntity<?> listarCategorias(){
        return new ResponseEntity<>(categoriaService.obtenerCategorias(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCategoria(@PathVariable("id") int id){
        CategoriaDto categoria = categoriaService.obtenerCategoria(id);
        if (categoria == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }
    @PostMapping("/guardar")
    public ResponseEntity<?> guardarCategoria(@RequestBody CategoriaDto categoriaDto) throws Exception {

        CategoriaDto categoriaSaved = categoriaService.guardarCategoria(categoriaDto);
        return new ResponseEntity<>(categoriaSaved, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarCategoria(@PathVariable("id") int id, @RequestBody CategoriaDto categoriaDto) throws Exception {
        CategoriaDto categoriaUpdated =  categoriaService.editarCategoria(id, categoriaDto);
        if (categoriaUpdated == null){
            return new ResponseEntity<>("La categoria que desea editar no existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoriaUpdated, HttpStatus.ACCEPTED);
    }

    @GetMapping("problemas-categoria")
    public ResponseEntity<?> getNumProblemasXCategoria(){
        return new ResponseEntity<>(categoriaService.obtenerNumProblemasByCategoria(), HttpStatus.OK);

    }
}
