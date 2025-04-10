package clinica.medica.dtos;

import jakarta.validation.constraints.NotBlank;

public record PacientesDto(
        @NotBlank
        String name,
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        String cpf,
        @NotBlank
        String endereco,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        @NotBlank
        String uf,
        String cep) {
}
