package br.trabalho.trab.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import br.trabalho.trab.model.Inquilino;

public interface InquilinoRepository extends Neo4jRepository<Inquilino, Long> {
    Inquilino findByName(String name);
    List<Inquilino> findByTeammatesName(String name);
    Optional<Inquilino> findById(String id);
}