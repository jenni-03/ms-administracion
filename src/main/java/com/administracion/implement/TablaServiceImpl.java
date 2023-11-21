package com.administracion.implement;

import com.administracion.dto.TablaDto;
import com.administracion.entity.Tabla;
import com.administracion.mapper.TablaMapper;
import com.administracion.repository.TablaRepository;
import com.administracion.service.TablaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TablaServiceImpl implements TablaService {

    @Autowired
    private TablaRepository tablaRepository;

    @Autowired
    private TablaMapper tablaMapper;

    @Override
    public List<TablaDto> obtenerTablas() {
        List<Tabla> tablas = tablaRepository.findAll();
        return tablas.stream()
                .map(tablaMapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public TablaDto obtenerTabla(int id) {
        Optional<Tabla> optionalTabla = tablaRepository.findById(id);

        if (optionalTabla.isPresent()) {
            Tabla tabla = optionalTabla.get();
            return tablaMapper.toDto(tabla);
        }
        else return null;

    }

    @Override
    public TablaDto guardarTabla(TablaDto tablaDto) {
        Tabla tabla = tablaMapper.toEntity(tablaDto);
        Tabla savedTabla = null;
        if (tablaRepository.findById(tabla.getId()).isEmpty()) {
            savedTabla = tablaRepository.save(tabla);
        } else {
            throw new RuntimeException("La tabla ya existe");
        }
        return tablaMapper.toDto(savedTabla);
    }

    @Override
    public TablaDto editarTabla(int id, TablaDto tablaDto) {
        Tabla tablaFound = tablaRepository.findById(id).get();
        tablaMapper.updateEntity(tablaDto, tablaFound);
        Tabla savedTabla = tablaRepository.save(tablaFound);
        return tablaMapper.toDto(savedTabla);
    }

    @Override
    public boolean eliminarTabla(int id) {
        if (tablaRepository.findById(id).isEmpty()){
            return false;
        }
        tablaRepository.deleteById(id);
        return true;
    }
}
