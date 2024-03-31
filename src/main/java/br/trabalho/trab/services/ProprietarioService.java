package br.trabalho.trab.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.trabalho.trab.model.Proprietario;
import br.trabalho.trab.model.Moradia;
import br.trabalho.trab.repository.ProprietarioRepository;


@Service
public class ProprietarioService{

    private final ProprietarioRepository proprietarioRepository;

    @Autowired
    public ProprietarioService(ProprietarioRepository proprietarioRepository) {

        this.proprietarioRepository = proprietarioRepository;

    }

    public Proprietario createProprietario(Proprietario p){
        return null;
    }

    public Proprietario deleteProprietario(String id){
        return null;
    }

    public Proprietario getById(String id){
        return null;
    }

    public Proprietario getAll(String id){
        return null;
    }

    public Proprietario updateProprietario(Proprietario p){
        return null;
    }


}

