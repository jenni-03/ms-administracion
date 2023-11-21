package com.administracion.implement;

import com.administracion.dto.ProblemaDto;
import com.administracion.entity.Examen;
import com.administracion.entity.Problema;
import com.administracion.mapper.ProblemaMapper;
import com.administracion.repository.ProblemaRepository;
import com.administracion.service.ProblemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProblemaServiceImpl implements ProblemaService {

    @Autowired
    private ProblemaRepository problemaRepository;

    @Autowired
    private ProblemaMapper problemaMapper;


    @Override
    public List<ProblemaDto> obtenerProblemas(){
        List<Problema> problemas = problemaRepository.findAll();
        return problemas.stream()
                .map(problemaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProblemaDto obtenerProblema(int id) {
        Optional<Problema> optionalProblema = problemaRepository.findById(id);

        if (optionalProblema.isPresent()) {
            Problema problema = optionalProblema.get();
            return problemaMapper.toDto(problema);
        }
        else return null;
    }

    @Override
    public ProblemaDto guardarProblema(ProblemaDto problemaDto) {
        Problema problema = problemaMapper.toEntity(problemaDto);
        Problema savedProblema = null;
        if (problemaRepository.findById(problema.getId()).isEmpty()) {
            savedProblema = problemaRepository.save(problema);
        } else {
            throw new RuntimeException("El problema ya existe");
        }
        return problemaMapper.toDto(savedProblema);
    }

    @Override
    public ProblemaDto editarProblema(int id, ProblemaDto problemaDto) {
        Problema problemaFound = problemaRepository.findById(id).get();
        problemaMapper.updateEntity(problemaDto, problemaFound);
        Problema savedExamen = problemaRepository.save(problemaFound);
        return problemaMapper.toDto(savedExamen);
    }

    @Override
    public boolean eliminarProblema(int id) {
        if (problemaRepository.findById(id).isEmpty()){
            return false;
        }
        problemaRepository.deleteById(id);
        return true;
    }



}
