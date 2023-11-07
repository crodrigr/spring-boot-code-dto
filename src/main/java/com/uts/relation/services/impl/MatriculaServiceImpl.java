package com.uts.relation.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uts.relation.config.EstudianteDTOConverte;
import com.uts.relation.config.MatriculaDTOConverte;
import com.uts.relation.dto.EstudianteDTO;
import com.uts.relation.dto.MatriculaDTO;
import com.uts.relation.repositories.EstudianteRepository;
import com.uts.relation.repositories.MatriculaRepository;
import com.uts.relation.repositories.entities.EstudianteEntity;
import com.uts.relation.repositories.entities.MatriculaEntity;
import com.uts.relation.services.MatriculaService;



@Service
public class MatriculaServiceImpl implements MatriculaService {
    
    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired EstudianteRepository estudianteRepository;

   @Autowired
    private MatriculaDTOConverte convert;

    
    @Override
    @Transactional
    public MatriculaDTO save(MatriculaDTO matricula) {

        Optional<EstudianteEntity> estuidanteOpintal= estudianteRepository.findById(matricula.getEstudianteId());       

        if(estuidanteOpintal.isPresent()){
           MatriculaEntity matriculaEntity=convert.convertMatriculaEntity(matricula);
           matriculaEntity.setEstudiante(estuidanteOpintal.get());
           matriculaRepository.save(matriculaEntity); 
           return convert.converMatriculaDTO(matriculaEntity);
                  
           
        }
        return null;        
    }

    @Override
    @Transactional(readOnly = true)
    public List<MatriculaDTO> findAll() {
         List<MatriculaEntity> matriculasEntity =(List<MatriculaEntity>) matriculaRepository.findAll();
         return matriculasEntity.stream()
                                .map(matricula->convert.converMatriculaDTO(matricula))
                                .toList();
         
    }
    
}
