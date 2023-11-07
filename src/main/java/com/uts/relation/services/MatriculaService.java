package com.uts.relation.services;

import java.util.List;

import com.uts.relation.dto.MatriculaDTO;

public interface MatriculaService {

    MatriculaDTO save(MatriculaDTO matricula);

    List<MatriculaDTO> findAll();
    
}
