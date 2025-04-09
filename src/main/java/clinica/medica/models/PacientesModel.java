package clinica.medica.models;

import jakarta.persistence.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Entity
@Table(name = "pacientes")
public class PacientesModel extends RepresentationModel<PacientesModel> implements Serializable {

    private static final long serialVersionUID = 1L;

    //COLUNAS DAS TABELAS

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "IdPacientes")
    private Integer idPacientes;

    @Column(name = "nome")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "numero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "uf")
    private String uf;

    @Column(name = "cep")
    private String cep;
    //CONSTRUTOR

    public PacientesModel() {}

    public PacientesModel(Integer idPacientes, String name, String email, String telefone, String cpf, String endereco, String numero, String complemento, String bairro, String cidade, String uf, String cep) {
        this.idPacientes = idPacientes;
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public PacientesModel(Link initialLink, Integer idPacientes, String name, String email, String telefone, String cpf, String endereco, String numero, String complemento, String bairro, String cidade, String uf, String cep) {
        super(initialLink);
        this.idPacientes = idPacientes;
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public PacientesModel(Iterable<Link> initialLinks, Integer idPacientes, String name, String email, String telefone, String cpf, String endereco, String numero, String complemento, String bairro, String cidade, String uf, String cep) {
        super(initialLinks);
        this.idPacientes = idPacientes;
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    //GETTERS E SETTERS

    public Integer getIdPacientes() {
        return idPacientes;
    }

    public void setIdPacientes(Integer idPacientes) {
        this.idPacientes = idPacientes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
