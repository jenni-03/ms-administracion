package com.administracion.dto;

import lombok.Data;

@Data
public class TablaDto {

    private int id;
    private String nombre;
    private String descripcion;
    private ProblemaDto problema;

}
