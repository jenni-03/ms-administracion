package com.administracion.service;

import com.administracion.dto.CategoriaDto;
import com.administracion.dto.ExamenDto;
import com.administracion.dto.ProblemasXCategoriaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoriaService {

    public List<CategoriaDto> obtenerCategorias();

    public CategoriaDto obtenerCategoria(int id);

    public CategoriaDto guardarCategoria(CategoriaDto categoriaDto);

    public CategoriaDto editarCategoria(int id, CategoriaDto categoriaDto);

    public boolean eliminarCategoria(int id);

    public List<ProblemasXCategoriaDto> obtenerNumProblemasByCategoria();
}
