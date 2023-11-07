package com.uts.relation.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uts.relation.config.EstudianteDTOConverte;
import com.uts.relation.dto.EstudianteDTO;
import com.uts.relation.dto.MatriculaDTO;
import com.uts.relation.dto.UniversidadDTO;
import com.uts.relation.repositories.EstudianteRepository;
import com.uts.relation.repositories.entities.EstudianteEntity;
import com.uts.relation.repositories.entities.MatriculaEntity;
import com.uts.relation.repositories.entities.UniversidadEntity;
import com.uts.relation.services.EstudianteService;

import jakarta.transaction.Transactional;

@Service
public class EstudianteServiceImpl  implements EstudianteService{

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private EstudianteDTOConverte convert;


    @Override
    @Transactional
    public List<EstudianteDTO> findAll() {
        List<EstudianteEntity> estudiantesEntity= (List<EstudianteEntity>) estudianteRepository.findAll();
        List<EstudianteDTO> estudiantesDTO=new ArrayList<>();       

           for(EstudianteEntity  estudiante  :estudiantesEntity){
                estudiantesDTO.add(convert.converEstudianteDTO(estudiante));
          }
          return estudiantesDTO;

        
       
    }
    
}
