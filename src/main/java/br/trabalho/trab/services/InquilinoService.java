package br.trabalho.trab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.trabalho.trab.model.Inquilino;
import br.trabalho.trab.model.Moradia;
import br.trabalho.trab.repository.InquilinoRepository;

@Service
public class InquilinoService {
 
 private final InquilinoRepository inquilinoRepository;


 public InquilinoService(InquilinoRepository inquilinoRepository) {
     this.inquilinoRepository = inquilinoRepository;
 }

 
 public Inquilino createInquilino(Inquilino inquilino) {
     
     if (inquilino != null && inquilino.getId() == null) {
         return inquilinoRepository.save(inquilino); // Salva o inquilino no banco de dados
     } else {
         throw new IllegalArgumentException("O Inquilino fornecido é inválido ou já possui um ID.");
     }
 }
 

 public void deleteInquilino(Inquilino inquilino) {
     if (inquilino != null && inquilino.getId() != null) {
         inquilinoRepository.delete(inquilino); // Exclui o inquilino do banco de dados
     } else {
         throw new IllegalArgumentException("O Inquilino fornecido é inválido ou não possui um ID.");
     }
 }


 public Inquilino updateInquilino (Inquilino inquilino){
  if (inquilino != null && inquilino.getId() != null) {
   Inquilino existingInquilino = inquilinoRepository.findById(inquilino.getId()).orElseThrow(() -> new IllegalArgumentException("O Inquilino fornecido não existe."));
   existingInquilino.setName(inquilino.getName());
   existingInquilino.setDtVencimentoAlugel(inquilino.getDtVencimentoAlugel());
   existingInquilino.setDtVencimentContrato(inquilino.getDtVencimentContrato());
   existingInquilino.setValorAluguel(inquilino.getValorAluguel());
   existingInquilino.setMoradia(inquilino.getMoradia());
   return inquilinoRepository.save(existingInquilino);
  } else {
   throw new IllegalAccessError("O iquilino fornecido é invalido ou nao possui um ID.");
  }
 }


public Inquilino findInquilinoByName(String name) {
    return inquilinoRepository.findByName(name);
}



public List<Inquilino> getAllInquilinos() {
    return inquilinoRepository.findAll();
}



public long countInquilinos() {
    return inquilinoRepository.count();
}


}
