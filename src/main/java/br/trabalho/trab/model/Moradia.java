package br.trabalho.trab.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;


import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Node("Moradia")
public class Moradia {
 
 @Id
 @GeneratedValue
 private String id;
 
 @NonNull
 private String tipo;
 
 @NonNull
 private String cep;
 
 @NonNull
 private String endereco;
 
 @NonNull
 private int numero;

 @NonNull
 private int area;

 @NonNull
 private int nQuartos;

 @NonNull
 private int nBanheiro;

 private String logradouro;
 
 @JsonIgnore
 @Relationship(type = "ABRIGA_EM", direction = Direction.OUTGOING)
 private List<Inquilino> inquilinos = new ArrayList<>();
 
}