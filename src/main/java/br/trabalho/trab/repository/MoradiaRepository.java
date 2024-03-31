package br.trabalho.trab.repository;

import br.trabalho.trab.model.Moradia;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MoradiaRepository extends Neo4jRepository<Moradia, String>{

}
