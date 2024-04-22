package br.trabalho.trab.controllers;

import br.trabalho.trab.model.Proprietario;
import br.trabalho.trab.services.ProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    private final ProprietarioService service;

    @Autowired
    public ProprietarioController(ProprietarioService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Proprietario getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping("/")
    public List<Proprietario> getAll() {
        return service.getAll();
    }

    @PostMapping("/")
    public Proprietario createProprietario(@RequestBody Proprietario proprietario) {
        return service.createProprietario(proprietario);
    }

    @PutMapping("/")
    public Proprietario updateProprietario(@RequestBody Proprietario proprietario) {
        return service.updateProprietario(proprietario);
    }

    @DeleteMapping("/{id}")
    public Proprietario deleteProprietario(@PathVariable String id) {
        Proprietario proprietario = this.service.getById(id);
        service.deleteProprietario(id);
        return proprietario;
    }

    @PostMapping("/{proprietarioId}/moradias/{moradiaId}")
    public ResponseEntity<?> associarMoradiaAProprietario(@PathVariable String proprietarioId, @PathVariable String moradiaId) {
        
            try {
                if( proprietarioId != null &&  moradiaId != null){
                    service.associarMoradiaAProprietario(moradiaId, proprietarioId);
                    return ResponseEntity.ok().build();    
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id Inválido");
                }
            } catch (Exception e) {
                
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( e.getMessage());
            }
        
        
    }
}
