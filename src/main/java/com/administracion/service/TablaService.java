package com.administracion.service;


import com.administracion.dto.TablaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TablaService {

    public List<TablaDto> obtenerTablas();

    public TablaDto obtenerTabla(int id);

    public TablaDto guardarTabla(TablaDto tablaDto);

    public TablaDto editarTabla(int id, TablaDto tablaDto);

    public boolean eliminarTabla(int id);
}
