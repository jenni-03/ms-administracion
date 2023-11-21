package com.administracion.mapper;

import com.administracion.dto.ProblemaDto;
import com.administracion.dto.TablaDto;
import com.administracion.entity.Problema;
import com.administracion.entity.Tabla;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TablaMapper {

    Tabla toEntity(TablaDto tablaDto);
    TablaDto toDto(Tabla tabla);
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(TablaDto tablaDto, @MappingTarget Tabla tabla);
}
