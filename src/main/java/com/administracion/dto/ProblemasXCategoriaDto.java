package com.administracion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProblemasXCategoriaDto {
    private String categoria;
    private int cantidadProblemas;
}
