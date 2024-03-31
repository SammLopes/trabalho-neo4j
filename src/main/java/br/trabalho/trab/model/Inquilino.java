package br.trabalho.trab.model;

import java.util.Date;

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
@Node("Inquilino")
public class Inquilino {
 @Id
 @GeneratedValue
 private String  id;

 @NonNull
 private String name;

 @NonNull
 private Date dtVencimentoAlugel;

 @NonNull
 private Date dtVencimentContrato;

 @NonNull
 private int valorAluguel;
 
 @JsonIgnore
 @Relationship(type = "MORA_EM", direction = Direction.OUTGOING)
 private Moradia moradia ;
}