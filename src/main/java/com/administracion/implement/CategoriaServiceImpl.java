package com.administracion.implement;

import com.administracion.dto.CategoriaDto;
import com.administracion.dto.ProblemasXCategoriaDto;
import com.administracion.dto.ProblemasXCategoriaProjection;
import com.administracion.entity.Categoria;
import com.administracion.entity.Examen;
import com.administracion.mapper.CategoriaMapper;
import com.administracion.repository.CategoriaRepository;
import com.administracion.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;
    @Override
    public List<CategoriaDto> obtenerCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream()
                .map(categoriaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDto obtenerCategoria(int id) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);

        if (optionalCategoria.isPresent()) {
            Categoria categoria = optionalCategoria.get();
            return categoriaMapper.toDto(categoria);
        }
        else return null;
    }

    @Override
    public CategoriaDto guardarCategoria(CategoriaDto categoriaDto) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDto);
        Categoria savedCategoria = null;
        if (categoriaRepository.findById(categoria.getId()).isEmpty()) {
            savedCategoria = categoriaRepository.save(categoria);
        } else {
            throw new RuntimeException("El examen ya existe");
        }
        return categoriaMapper.toDto(savedCategoria);
    }

    @Override
    public CategoriaDto editarCategoria(int id, CategoriaDto categoriaDto) {
        Categoria categoriaFound = categoriaRepository.findById(id).get();
        categoriaMapper.updateEntity(categoriaDto, categoriaFound);
        Categoria savedCategoria = categoriaRepository.save(categoriaFound);
        return categoriaMapper.toDto(savedCategoria);
    }

    @Override
    public boolean eliminarCategoria(int id) {
        if (categoriaRepository.findById(id).isEmpty()){
            return false;
        }
        categoriaRepository.deleteById(id);
        return true;
    }

    @Override
    public List<ProblemasXCategoriaDto> obtenerNumProblemasByCategoria() {
        List<ProblemasXCategoriaProjection> projections = categoriaRepository.findProblemasByCategoria();
        List<ProblemasXCategoriaDto> problemasByCategoriaDto = new ArrayList<>();

        for (ProblemasXCategoriaProjection projection : projections) {
            ProblemasXCategoriaDto dto = new ProblemasXCategoriaDto(projection.getCategoria(), projection.getCantidadProblemas());
            problemasByCategoriaDto.add(dto);
        }

        return problemasByCategoriaDto;
    }
}
