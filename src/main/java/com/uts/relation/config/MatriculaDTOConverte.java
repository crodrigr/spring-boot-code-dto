package com.uts.relation.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uts.relation.dto.MatriculaDTO;
import com.uts.relation.repositories.entities.MatriculaEntity;

@Component
public class MatriculaDTOConverte {

    @Autowired
    private ModelMapper dbm;

    public MatriculaDTO converMatriculaDTO(MatriculaEntity matricula){
        
        MatriculaDTO matriculaDTO=dbm.map(matricula,MatriculaDTO.class);
        matriculaDTO.setEstudianteId(matricula.getId());    
        return matriculaDTO;     

    }

  
    public MatriculaEntity convertMatriculaEntity(MatriculaDTO matriculaDTO){
          return dbm.map(matriculaDTO,MatriculaEntity.class);
    }

    
    
}
