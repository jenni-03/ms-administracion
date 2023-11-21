package com.administracion.implement;

import com.administracion.dto.CategoriaDto;
import com.administracion.mapper.CategoriaMapper;
import com.administracion.repository.CategoriaRepository;
import com.administracion.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Override
    public List<CategoriaDto> obtenerCategorias() {
        return null;
    }

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public CategoriaDto obtenerCategoria(int id) {
        //List<Categoria> categorias = categoriaRepository.findAll();
        //return categorias.stream()
                //.map(categoriaMapper::toDto)
                //.collect(Collectors.toList());
        return null;
    }

    @Override
    public CategoriaDto guardarCategoria(CategoriaDto categoriaDto) {
        return null;
    }

    @Override
    public CategoriaDto editarCategoria(int id, CategoriaDto categoriaDto) {
        return null;
    }

    @Override
    public boolean eliminarCategoria(int id) {
        return false;
    }
}
