package clinica.medica.dtos;

import clinica.medica.Enum.EspecialidadeEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicosDto(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String telefone,
        @NotBlank
        String cpf,
        String endereco,
        String numero,
        String complemento,
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        @Pattern(regexp = "\\d{8}")
        @NotBlank
        String cep,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        EspecialidadeEnum especialidade) {
}
