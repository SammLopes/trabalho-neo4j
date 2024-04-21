package br.trabalho.trab.services;

import br.trabalho.trab.model.Inquilino;
import br.trabalho.trab.model.Moradia;
import br.trabalho.trab.model.Proprietario;
import br.trabalho.trab.repository.MoradiaRepository;
import br.trabalho.trab.repository.ProprietarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MoradiaService{

    private final MoradiaRepository moradiaRepository;
    private final ProprietarioRepository proprietarioRepository;

    @Autowired
    public MoradiaService(MoradiaRepository moradiaRepository, ProprietarioRepository proprietarioRepository) {
        this.moradiaRepository = moradiaRepository;
        this.proprietarioRepository = proprietarioRepository;
    }

    public Moradia getById(String id){
        return moradiaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Moradia não encontrada para o ID fornecido: " + id));
    }

    public List<Moradia> getAll(){
        return moradiaRepository.findAll();
    }

    public Moradia createMoradia(Moradia m){
        if( m != null ){
            return moradiaRepository.save(m);
        } else {
            throw new IllegalArgumentException("A moradia fornecida é inválida ou já possui um ID.");
        }
    }

    public Moradia updateMoradia(Moradia m){
        return moradiaRepository.save(m);
    }

    public void deleteMoradia(String id){
        Moradia m = this.getById(id);
        if (m != null) {
            moradiaRepository.delete(m);
        } else {
            throw new IllegalArgumentException("A moradia fornecida é inválida ou já possui um ID.");
        }
    }

    public void associarInquilinoAMoradia(String moradiaId, Inquilino inquilino) {
        Moradia moradia = getById(moradiaId);
        moradia.addInquilino(inquilino);
    }

    public void associarMoradiaAProprietario(String moradiaId, String proprietarioId) {
        Moradia moradia = getById(moradiaId);
        Proprietario proprietario = proprietarioRepository.findById(proprietarioId)
                .orElseThrow(() -> new IllegalArgumentException("Proprietário não encontrado para o ID fornecido: " + proprietarioId));
        moradia.setProprietario(proprietario);
    }

    
}
