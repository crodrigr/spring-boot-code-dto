package com.uts.relation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uts.relation.dto.EstudianteDTO;
import com.uts.relation.services.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;


    @GetMapping("/")
    public List<EstudianteDTO> findAll(){
        return estudianteService.findAll();
    }
    
}
