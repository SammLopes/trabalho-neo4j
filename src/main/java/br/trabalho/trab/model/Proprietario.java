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
@Node("Proprietario")
public class Proprietario {
    @Id
    @GeneratedValue
    private String id;

    @NonNull
    private String name;

    @NonNull
    private int celular;

    @NonNull
    private String cpf;

    @JsonIgnore
    @Relationship(type = "E_DONO", direction = Direction.OUTGOING)
    private List<Moradia> moradias = new ArrayList<>();

    @JsonIgnore
    @Relationship(type = "AMOR_ENTERNO", direction = Direction.OUTGOING)
    private List<Inquilino> inquilinos = new ArrayList<>();

    // Método para adicionar uma moradia ao proprietário
    public void addMoradia(Moradia moradia) {
        this.moradias.add(moradia);
    }
    
    public void addInquilino(Inquilino inquilino) {
        this.inquilinos.add(inquilino);
    }
}
