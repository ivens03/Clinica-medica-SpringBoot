package clinica.medica.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               // Lombok: gera getters e setters automaticamente
@NoArgsConstructor  // Lombok: gera o construtor padrão (necessário para o JPA)
@AllArgsConstructor // Lombok: gera o construtor com todos os campos
@MappedSuperclass   // superclasse mapeada pelo JPA
public abstract class PessoasModel {

    @Column(name = "nome", unique = true, nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "telefone", unique = true, nullable = false, length = 11)
    private String telefone;

    @Column(name = "cpf", unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(name = "endereco", unique = true, nullable = false, length = 50)
    private String endereco;

    @Column(name = "numero", unique = true, nullable = false)
    private String numero;

    @Column(name = "complemento", unique = true, nullable = false, length = 100)
    private String complemento;

    @Column(name = "bairro", unique = true, nullable = false, length = 100)
    private String bairro;

    @Column(name = "cidade", unique = true, nullable = false, length = 100)
    private String cidade;

    @Column(name = "uf", unique = true, nullable = false, length = 2)
    private String uf;

    @Column(name = "cep", unique = true, nullable = false, length = 8)
    private String cep;
}
