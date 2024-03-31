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

        return moradiaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Inquilino não encontrado para o ID fornecido: " + id));
    }


    public List<Moradia> getAll(){

        return moradiaRepository.findAll();

    }

    public Moradia createMoradia(Moradia m){

        if( m != null ){

            return moradiaRepository.save(m);

        }else{

            throw new IllegalArgumentException("A moradia fornecido é inválida ou já possui um ID.");

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

            throw new IllegalArgumentException("A moradia fornecido é inválida ou já possui um ID.");

        }

    }

}




















