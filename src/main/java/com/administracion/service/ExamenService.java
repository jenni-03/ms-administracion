package com.administracion.service;

import com.administracion.dto.ExamenDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamenService {

    public List<ExamenDto> obtenerExamenes();

    public ExamenDto obtenerExamen(int id);

    public ExamenDto guardarExamen(ExamenDto examenDto);

    public ExamenDto editarExamen(int id, ExamenDto examenDto);

    public boolean eliminarExamen(int id);
}
