package br.trabalho.trab.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import br.trabalho.trab.model.Inquilino;

public interface InquilinoRepository extends Neo4jRepository<Inquilino, String> {
    Inquilino findByName(String name);
    Optional<Inquilino> findById(String id);
}