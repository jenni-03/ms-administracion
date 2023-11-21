package com.administracion.dto;

import lombok.Data;

@Data
public class ProblemaDto {

    private int id;
    private String nombre;
    private String descripcion;
    private String docente;
    private String nombreBase;
    private boolean estado;
    private CategoriaDto categoria;

}
