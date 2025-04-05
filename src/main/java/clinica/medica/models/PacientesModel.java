package clinica.medica.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               // Lombok: gera getters, setters, etc.
@NoArgsConstructor  // Construtor padrão (necessário para o JPA)
@AllArgsConstructor // Gera construtor com todos os campos (incluindo os herdados)
@Entity
@Table(name = "pacientes")
public class PacientesModel extends PessoasModel {

    @Id
    @Column(name = "IdPacientes", nullable = false)
    private Integer idPacientes;
}
