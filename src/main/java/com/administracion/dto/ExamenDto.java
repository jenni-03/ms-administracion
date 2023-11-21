package com.administracion.dto;

import lombok.Data;
import java.util.Date;

@Data
public class ExamenDto {

    private int id;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private String token;
    private int cantidad;
    private ProblemaDto problema;

}
