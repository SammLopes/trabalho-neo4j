package br.trabalho.trab.services;

import br.trabalho.trab.model.Inquilino;
import br.trabalho.trab.model.Moradia;
import br.trabalho.trab.model.Proprietario;
import br.trabalho.trab.repository.InquilinoRepository;
import br.trabalho.trab.repository.MoradiaRepository;
import br.trabalho.trab.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProprietarioService {

    private final ProprietarioRepository proprietarioRepository;
    private final MoradiaRepository moradiaRepository;
    private final InquilinoRepository inquilinoRepository;

    @Autowired
    public ProprietarioService(ProprietarioRepository proprietarioRepository, MoradiaRepository moradiaRepository,
            InquilinoRepository inquilinoRepository) {
        this.proprietarioRepository = proprietarioRepository;
        this.moradiaRepository = moradiaRepository;
        this.inquilinoRepository = inquilinoRepository;
    }

    public Proprietario getById(String id) {
        return proprietarioRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Proprietário não encontrado para o ID fornecido: " + id));
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

    // feito pelo samuel
    public void associarMoradiaAProprietario(String moradiaId, String proprietarioId) {

        Moradia moradia = moradiaRepository.findById(moradiaId)
                .orElseThrow(
                        () -> new IllegalArgumentException("Moradia não encontrada para o ID fornecido: " + moradiaId));

        System.out.println("id prop " + proprietarioId);
        Proprietario proprietario = proprietarioRepository.findById(proprietarioId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Proprietário não encontrado para o ID fornecido: " + proprietarioId));

        // proprietario.addMoradia(moradia);
        try {
            proprietario.getMoradias().add(moradia);
            proprietarioRepository.save(proprietario);
        } catch (Exception e) {
            throw new IllegalArgumentException("O proprietário fornecido é inválido.");
        }

    }

    public void AMOR_ENTERNO(String proprietarioId, String inquilinoId) {

        System.out.println("id inquilino " + inquilinoId);
        Inquilino inquilino = inquilinoRepository.findById(inquilinoId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Proprietário não encontrado para o ID fornecido: " + inquilinoId));

        System.out.println("id prop " + proprietarioId);
        Proprietario proprietario = proprietarioRepository.findById(proprietarioId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Proprietário não encontrado para o ID fornecido: " + proprietarioId));
        try {
            proprietario.getInquilinos().add(inquilino);
            proprietarioRepository.save(proprietario);
        } catch (Exception e) {
            throw new IllegalArgumentException("O proprietário fornecido é inválido.");
        }
    }
}
