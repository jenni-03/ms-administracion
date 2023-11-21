package com.administracion.mapper;

import com.administracion.dto.CategoriaDto;
import com.administracion.entity.Categoria;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    Categoria toEntity(CategoriaDto categoriaDto);
    CategoriaDto toDto(Categoria categoria);
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(CategoriaDto categoriaDto, @MappingTarget Categoria categoria);
}
