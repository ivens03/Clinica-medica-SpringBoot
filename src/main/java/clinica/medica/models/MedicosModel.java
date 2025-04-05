package clinica.medica.models;

import clinica.medica.Enum.EspecialidadeEnum;
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
@Table(name = "medicos")
public class MedicosModel extends PessoasModel {

    @Id
    @Column(name = "IdMedico", nullable = false)
    private Integer idMedico;

    @Column(name = "crm", unique = true, nullable = false)
    private String crm;

    @Column(name = "especialidade", nullable = false)
    private EspecialidadeEnum especialidade;
}
