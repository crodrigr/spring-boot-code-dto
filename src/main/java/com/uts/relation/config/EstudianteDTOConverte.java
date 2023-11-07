package com.uts.relation.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uts.relation.dto.EstudianteDTO;
import com.uts.relation.repositories.entities.EstudianteEntity;

@Component
public class EstudianteDTOConverte {

    @Autowired
    private ModelMapper dbm;

    public EstudianteDTO converEstudianteDTO(EstudianteEntity estudiante){

           
                EstudianteDTO estudianteDTO=dbm.map(estudiante,EstudianteDTO.class);
                if(estudiante.getMatricula()!=null){
                  estudianteDTO.setMatriculaId(estudiante.getMatricula().getId());
                }
                estudianteDTO.setUniversidadId(estudiante.getUniversidad().getId());

                return estudianteDTO;
                
    

    }

    public EstudianteEntity converEstudianteEntity(EstudianteDTO estudianteDTO){
          return dbm.map(estudianteDTO,EstudianteEntity.class);
          
    }
    
}
