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

 @Autowired
 public InquilinoService(InquilinoRepository inquilinoRepository) {
     this.inquilinoRepository = inquilinoRepository;
 }

 @Transactional
 public Inquilino createInquilino(Inquilino inquilino) {
     if (inquilino != null && inquilino.getId() == null) {
         return inquilinoRepository.save(inquilino); // Salva o inquilino no banco de dados
     } else {
         throw new IllegalArgumentException("O Inquilino fornecido é inválido ou já possui um ID.");
     }
 }

 @Transactional
 public void deleteInquilino(Inquilino inquilino) {
     if (inquilino != null && inquilino.getId() != null) {
         inquilinoRepository.delete(inquilino); // Exclui o inquilino do banco de dados
     } else {
         throw new IllegalArgumentException("O Inquilino fornecido é inválido ou não possui um ID.");
     }
 }
 @Transactional
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

 @Transactional(readOnly = true)
public Inquilino findInquilinoByName(String name) {
    return inquilinoRepository.findByName(name);
}

 @Transactional(readOnly = true)
public Inquilino findInquilinoById(String id) {
    return inquilinoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Inquilino não encontrado para o ID fornecido: " + id));
}

@Transactional(readOnly = true)
public List<Inquilino> getAllInquilinos() {
    return inquilinoRepository.findAll();
}


@Transactional(readOnly = true)
public long countInquilinos() {
    return inquilinoRepository.count();
}


}
