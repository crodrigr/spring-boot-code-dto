package com.uts.relation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uts.relation.dto.MatriculaDTO;
import com.uts.relation.services.MatriculaService;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
      
      @Autowired
      private MatriculaService matriculaService;    


      @GetMapping("/")
      public List<MatriculaDTO> findAll(){
         return matriculaService.findAll();
      }


      @PostMapping("/")
      public MatriculaDTO save(@RequestBody MatriculaDTO matricula){
           return matriculaService.save(matricula);

      }

    
}
