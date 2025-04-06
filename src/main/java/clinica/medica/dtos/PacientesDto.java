package clinica.medica.dtos;

public record PacientesDto(
        String name,
        String email,
        String telefone,
        String cpf,
        String endereco,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String uf,
        String cep,
        String crm) {
}
