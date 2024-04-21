package br.trabalho.trab.controllers;
import java.util.List;

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

import br.trabalho.trab.model.Inquilino;
import br.trabalho.trab.services.InquilinoService;

@RestController
@RequestMapping("/inquilinos")
public class InquilinoController {

    private final InquilinoService inquilinoService;

    @Autowired
    public InquilinoController(InquilinoService inquilinoService) {
        this.inquilinoService = inquilinoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> createInquilino(@RequestBody Inquilino inquilino) {
        if (inquilino == null) {
            return ResponseEntity.badRequest().body("O Inquilino fornecido é nulo.");
        }
        try {
            Inquilino createdInquilino = inquilinoService.createInquilino(inquilino);
            return ResponseEntity.ok(createdInquilino);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<?> deletarInquilino(@RequestBody Inquilino inquilino) {
        if (inquilino == null) {
            return ResponseEntity.badRequest().body("O Inquilino fornecido é nulo.");
        }

        try {
            inquilinoService.deleteInquilino(inquilino);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/aturalizar")
    public ResponseEntity<?> updaInquilino(@RequestBody Inquilino inquilino) {
        if (inquilino == null) {
            return ResponseEntity.badRequest().body("O Inquilino fornecido é nulo.");
        }

        try {
            Inquilino updatedInquilino = inquilinoService.updateInquilino(inquilino);
            return ResponseEntity.ok(updatedInquilino);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/nome/{name}")
    public ResponseEntity<?> findInquilinoByName(@PathVariable String name) {
        if (name == null || name.isEmpty()) {
            return ResponseEntity.badRequest().body("O nome do Inquilino fornecido é inválido.");
        }

        try {
            Inquilino foundInquilino = inquilinoService.findInquilinoByName(name);
            return ResponseEntity.ok(foundInquilino);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/todos")
    public ResponseEntity<?> getAllInquilinos() {
        try {
            List<Inquilino> inquilinos = inquilinoService.getAllInquilinos();
            return ResponseEntity.ok(inquilinos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao buscar todos os inquilinos: " + e.getMessage());
        }
    }

    @GetMapping("/quantidade")
    public ResponseEntity<?> countInquilinos() {
        try {
            long count = inquilinoService.countInquilinos();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao contar inquilinos: " + e.getMessage());
        }
    }
}
