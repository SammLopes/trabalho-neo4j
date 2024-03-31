package br.trabalho.trab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import br.trabalho.trab.model.Moradia;
import br.trabalho.trab.services.MoradiaService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/moradias")
public class MoradiaController{

    private final MoradiaService service;

    @Autowired
    public MoradiaController(MoradiaService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public Moradia getById(@PathVariable String id){
        return null;
    }

    @GetMapping("/")
    public List<Moradia> getAll(){
        return null;
    }

    @PostMapping("/")
    public Moradia createMoradia(@RequestBody Moradia m){
        return null;
    }

    @PutMapping("/")
    public Moradia updateMoradia(@RequestBody Moradia m){
        return null;
    }

    @DeleteMapping("/{id}")
    public Moradia updateMoradia(@PathVariable String id){
        return null;
    }


}
