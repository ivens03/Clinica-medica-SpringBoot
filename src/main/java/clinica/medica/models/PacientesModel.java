package clinica.medica.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pacientes")
public class PacientesModel extends PessoasModel implements Serializable {

    private static final long serialVersionUID = 1L;

    //COLUNAS DAS TABELAS

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "IdPacientes")
    private Integer idPacientes;

    //CONSTRUTOR

    public PacientesModel() {}

    public PacientesModel(Integer idPacientes) {
        this.idPacientes = idPacientes;
    }

    public PacientesModel(String name, String email, String telefone, String cpf, String endereco, String numero, String complemento, String bairro, String cidade, String uf, String cep, Integer idPacientes) {
        super(name, email, telefone, cpf, endereco, numero, complemento, bairro, cidade, uf, cep);
        this.idPacientes = idPacientes;
    }

    //GETTERS E SETTERS

    public Integer getIdPacientes() {
        return idPacientes;
    }

    public void setIdPacientes(Integer idPacientes) {
        this.idPacientes = idPacientes;
    }
}
