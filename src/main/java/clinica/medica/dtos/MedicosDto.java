package clinica.medica.dtos;

import clinica.medica.Enum.EspecialidadeEnum;

public record MedicosDto(
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
        String crm,
        EspecialidadeEnum especialidade) {
}
