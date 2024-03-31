package br.trabalho.trab.services;

import br.trabalho.trab.model.Moradia;
import br.trabalho.trab.repository.MoradiaRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MoradiaService{

    private final MoradiaRepository moradiaRepository;

    @Autowired
    public MoradiaService(MoradiaRepository moradiaRepository){

        this.moradiaRepository = moradiaRepository;

    }

    public Moradia getById(String id){

        return null;

    }

    public Moradia getAll(){

        return null;

    }

    public Moradia crateMoradia(Moradia m){

        return null;

    }

    public Moradia updateMoradia(Moradia m){

        return null;

    }

    public Moradia deleteMoradia(String id){

        return null;

    }

}
