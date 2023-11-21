package com.administracion.service;


import com.administracion.dto.ProblemaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProblemaService {

    public List<ProblemaDto> obtenerProblemas();

    public ProblemaDto obtenerProblema(int id);

    public ProblemaDto guardarProblema(ProblemaDto problemaDto);

    public ProblemaDto editarProblema(int id, ProblemaDto problemaDto);

    public boolean eliminarProblema(int id);
}
