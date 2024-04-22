package br.trabalho.trab.services;

import br.trabalho.trab.model.Inquilino;
import br.trabalho.trab.model.Moradia;
import br.trabalho.trab.model.Proprietario;
import br.trabalho.trab.repository.InquilinoRepository;
import br.trabalho.trab.repository.MoradiaRepository;
import br.trabalho.trab.repository.ProprietarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MoradiaService {

    private final MoradiaRepository moradiaRepository;
    private final ProprietarioRepository proprietarioRepository;
    private final InquilinoRepository inquilinoRepository;

    @Autowired
    public MoradiaService(MoradiaRepository moradiaRepository, ProprietarioRepository proprietarioRepository,
            InquilinoRepository inquilinoRepository) {
        this.moradiaRepository = moradiaRepository;
        this.proprietarioRepository = proprietarioRepository;
        this.inquilinoRepository = inquilinoRepository;
    }

    public Moradia getById(String id) {
        return moradiaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Moradia não encontrada para o ID fornecido: " + id));
    }

    public List<Moradia> getAll() {
        return moradiaRepository.findAll();
    }

    public Moradia createMoradia(Moradia m) {
        if (m != null) {
            return moradiaRepository.save(m);
        } else {
            throw new IllegalArgumentException("A moradia fornecida é inválida ou já possui um ID.");
        }
    }

    public Moradia updateMoradia(Moradia m) {
        return moradiaRepository.save(m);
    }

    public void deleteMoradia(String id) {
        Moradia m = this.getById(id);
        if (m != null) {
            moradiaRepository.delete(m);
        } else {
            throw new IllegalArgumentException("A moradia fornecida é inválida ou já possui um ID.");
        }
    }

    public void associarInquilinoAMoradia(String moradiaId, String inquilinoId) {
        Moradia moradia = moradiaRepository.findById(moradiaId)
                .orElseThrow(
                        () -> new IllegalArgumentException("Moradia não encontrada para o ID fornecido: " + moradiaId));
        System.out.println(("id inquilino" + inquilinoId));
        Inquilino inquilino = inquilinoRepository.findById(inquilinoId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Inquilino não encontrado para o ID fornecido: " + inquilinoId));
        try {
            moradia.getInquilinos().add(inquilino);
            moradiaRepository.save(moradia);
        } catch (Exception e) {
            throw new IllegalArgumentException("A moradia fornecido é inválido.");
        }
    }

}
