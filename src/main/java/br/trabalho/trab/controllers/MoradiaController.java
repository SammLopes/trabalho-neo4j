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

import br.trabalho.trab.model.Inquilino;
import br.trabalho.trab.model.Moradia;
import br.trabalho.trab.services.MoradiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return service.getById(id);
    }

    @GetMapping("/")
    public List<Moradia> getAll(){
        return service.getAll();
    }

    @PostMapping("/")
    public Moradia createMoradia(@RequestBody Moradia m){
        return service.createMoradia(m);
    }

    @PutMapping("/")
    public Moradia updateMoradia(@RequestBody Moradia m){
        return service.updateMoradia(m);
    }

    @DeleteMapping("/{id}")
    public Moradia deleteMoradia(@PathVariable String id){
    
        Moradia m = this.service.getById(id);
        service.deleteMoradia(id);
        return m;
    
    }

    @PostMapping("/{moradiaId}/inquilinos")
    public ResponseEntity<?> associarInquilinoAMoradia(@PathVariable String moradiaId, @RequestBody Inquilino inquilino) {
        service.associarInquilinoAMoradia(moradiaId, inquilino);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{moradiaId}/proprietarios/{proprietarioId}")
    public ResponseEntity<?> associarMoradiaAProprietario(@PathVariable String moradiaId, @PathVariable String proprietarioId) {
        service.associarMoradiaAProprietario(moradiaId, proprietarioId);
        return ResponseEntity.ok().build();
    }


}
