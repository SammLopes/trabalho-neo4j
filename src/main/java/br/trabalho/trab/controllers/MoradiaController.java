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

import java.net.http.HttpResponse.ResponseInfo;
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
    public ResponseEntity<?> getById(@PathVariable String id){

        if(id != null){

            Moradia m =  service.getById(id);
            return ResponseEntity.ok(m);

        }else{

            return ResponseEntity.badRequest().body("O ID da Moradia fornecido é invalido.");

        }


    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        
        try {
            
            return ResponseEntity.ok(service.getAll());
            
        } catch (Exception e) {

            return ResponseEntity.badRequest().body("Não existe Moradias cadastradas");

        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createMoradia(@RequestBody Moradia m){
        
        if( m == null){

            return ResponseEntity.badRequest().body("Moradia inválida");
        
        }

        try {

            return ResponseEntity.ok(service.createMoradia(m));    
        
        } catch (Exception e) {
        
            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

    @PutMapping("/")
    public ResponseEntity<?> updateMoradia(@RequestBody Moradia m){
       
        if( m == null){

            return ResponseEntity.badRequest().body("Moradia inválida");
        
        }

        try {

            return ResponseEntity.ok(service.updateMoradia(m));    
        
        } catch (Exception e) {
        
            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMoradia(@PathVariable String id){

        if(id == null){

            return ResponseEntity.badRequest().body("ID invalido ");

        }

        try {

            Moradia m = this.service.getById(id);
            service.deleteMoradia(id);
            return ResponseEntity.ok(m);
            
        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());

        }


    }


}
