package bf.trabalho.trab.model;

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
@Node
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
 private List<Moradia> moradias = new ArrayList()<>;

 @JsonIgnore
 @Relationship(type = "AMOR_ENTERNO", direction = Direction.OUTGOING)
 private List<Inquilino> inquilinos = new ArrayList()<>;
 
}