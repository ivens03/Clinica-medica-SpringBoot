package clinica.medica.models;

import clinica.medica.Enum.EspecialidadeEnum;
import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "medicos")
public class MedicosModel extends PessoasModel implements Serializable {

    private static final long serialVersionUID = 1L;

    //COLUNAS DAS TABELAS

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdMedico")
    private Integer idMedico;

    @Column(name = "crm")
    private String crm;

    @Column(name = "especialidade")
    @Enumerated(EnumType.STRING)
    private EspecialidadeEnum especialidade;

    //CONSTRUTOR

    public MedicosModel() {}

    public MedicosModel(Integer idMedico, String crm, EspecialidadeEnum especialidade) {
        this.idMedico = idMedico;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public MedicosModel(String name, String email, String telefone, String cpf, String endereco, String numero, String complemento, String bairro, String cidade, String uf, String cep, Integer idMedico, String crm, EspecialidadeEnum especialidade) {
        super(name, email, telefone, cpf, endereco, numero, complemento, bairro, cidade, uf, cep);
        this.idMedico = idMedico;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    //GETTERS E SETTERS

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public EspecialidadeEnum getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(EspecialidadeEnum especialidade) {
        this.especialidade = especialidade;
    }
}
