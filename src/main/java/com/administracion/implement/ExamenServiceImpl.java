package com.administracion.implement;

import com.administracion.dto.ExamenDto;
import com.administracion.entity.Examen;
import com.administracion.mapper.ExamenMapper;
import com.administracion.repository.ExamenRepository;
import com.administracion.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExamenServiceImpl implements ExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private ExamenMapper examenMapper;

    @Override
    public List<ExamenDto> obtenerExamenes() {
        List<Examen> examenes = examenRepository.findAll();
        return examenes.stream()
                .map(examenMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExamenDto obtenerExamen(int id) {
        Optional<Examen> optionalExamen = examenRepository.findById(id);

        if (optionalExamen.isPresent()) {
            Examen examen = optionalExamen.get();
            return examenMapper.toDto(examen);
        }
        else return null;

    }

    @Override
    public ExamenDto guardarExamen(ExamenDto examenDto) {
        Examen examen = examenMapper.toEntity(examenDto);
        Examen savedExamen = null;
        if (examenRepository.findById(examen.getId()).isEmpty()) {
            savedExamen = examenRepository.save(examen);
        } else {
            throw new RuntimeException("El examen ya existe");
        }
        return examenMapper.toDto(savedExamen);
    }

    @Override
    public ExamenDto editarExamen(int id, ExamenDto examenDto) {
        Examen exFound = examenRepository.findById(id).get();
        examenMapper.updateEntity(examenDto, exFound);
        Examen savedExamen = examenRepository.save(exFound);
        return examenMapper.toDto(savedExamen);
    }

    @Override
    public boolean eliminarExamen(int id) {
        if (examenRepository.findById(id).isEmpty()){
            return false;
        }
        examenRepository.deleteById(id);
        return true;
    }
}
