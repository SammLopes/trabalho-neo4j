package br.trabalho.trab.services;

import br.trabalho.trab.model.Proprietario;
import br.trabalho.trab.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProprietarioService {

    private final ProprietarioRepository proprietarioRepository;

    @Autowired
    public ProprietarioService(ProprietarioRepository proprietarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
    }

    public Proprietario getById(String id) {
        return proprietarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Proprietário não encontrado para o ID fornecido: " + id));
    }

    public List<Proprietario> getAll() {
        return proprietarioRepository.findAll();
    }

    public Proprietario createProprietario(Proprietario proprietario) {
        if (proprietario != null) {
            return proprietarioRepository.save(proprietario);
        } else {
            throw new IllegalArgumentException("O proprietário fornecido é inválido.");
        }
    }

    public Proprietario updateProprietario(Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }

    public void deleteProprietario(String id) {
        Proprietario proprietario = this.getById(id);
        if (proprietario != null) {
            proprietarioRepository.delete(proprietario);
        } else {
            throw new IllegalArgumentException("O proprietário fornecido é inválido.");
        }
    }
}
