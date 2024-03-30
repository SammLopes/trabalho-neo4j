package br.trabalho.trab.repository;

import br.trabalho.trab.model.Proprietario;
import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProprietarioRepository extends Neo4jRepository<Proprietario, String>{

}
