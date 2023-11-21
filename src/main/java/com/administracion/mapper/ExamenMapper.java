package com.administracion.mapper;

import com.administracion.dto.ExamenDto;
import com.administracion.entity.Examen;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ExamenMapper {

    Examen toEntity(ExamenDto examenDto);
    ExamenDto toDto(Examen examen);
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(ExamenDto examenDto, @MappingTarget Examen examen);

}
