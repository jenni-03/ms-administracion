package com.administracion.mapper;

import com.administracion.dto.ExamenDto;
import com.administracion.dto.ProblemaDto;
import com.administracion.entity.Examen;
import com.administracion.entity.Problema;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProblemaMapper {

    Problema toEntity(ProblemaDto problemaDto);
    ProblemaDto toDto(Problema problema);
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(ProblemaDto problemaDto, @MappingTarget Problema problema);

}
