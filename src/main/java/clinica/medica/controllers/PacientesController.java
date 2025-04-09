package clinica.medica.controllers;

import clinica.medica.dtos.PacientesDto;
import clinica.medica.models.PacientesModel;
import clinica.medica.repositories.PacientesRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@Tag(name = "Pacientes", description = "Controller responsavel pelos os pacientes")
public class PacientesController {

    @Autowired
    PacientesRepository pacientesRepository;

    @Operation(summary = "Cadastrar Pacientes", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Salvo no DB com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar"),
            @ApiResponse(responseCode = "422", description = "Dados para que possa ser salvo são inválidos")
    })
    @PostMapping("/pacientes")
    public ResponseEntity<PacientesModel> savePacientes(@RequestBody @Valid PacientesDto pacientesDto) {
        var pacientesModel = new PacientesModel();
        BeanUtils.copyProperties(pacientesDto, pacientesModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacientesRepository.save(pacientesModel));
    }

    @Operation(summary = "Pega toda base de dados dos pacientes.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorno de todos os pacientes feito com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao encontrar todos os pacientes")
    })
    @GetMapping("/pacientes")
    public ResponseEntity<List<PacientesModel>> getAllPacientes() {
        List<PacientesModel> pacientesList = pacientesRepository.findAll();
        if (!pacientesList.isEmpty()) {
            for(PacientesModel pacientes : pacientesList) {
                Integer id = pacientes.getIdPacientes();
                pacientes.add(linkTo(methodOn(PacientesController.class).getOnePaciente(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(pacientesList);
    }

    @Operation(summary = "Pega uma entidade dos banco de dados dos pacientes.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorno feito com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao encontrar o medico")
    })
    @GetMapping("/pacientes/{id}")
    public ResponseEntity<Object>getOnePaciente(@PathVariable(value = "id") Integer id) {
        Optional<PacientesModel> pacientesID = pacientesRepository.findById(id);
        if (pacientesID.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente nao encontrado");
        }
        pacientesID.get().add(linkTo(methodOn(PacientesController.class).getAllPacientes()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(pacientesID.get());
    }

    @Operation(summary = "Atualiza uma entidade dos banco de dados dos pacientes.", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização feito com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar"),
            @ApiResponse(responseCode = "422", description = "Dados para requisição inválidos")
    })
    @PutMapping("pacientesAtualizarcao/{id}")
    public ResponseEntity<Object>updatePaciente(@PathVariable(value = "id") Integer id, @RequestBody @Valid PacientesDto pacientesDto) {
        Optional<PacientesModel> pacientesID = pacientesRepository.findById(id);
        if (pacientesID.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente nao encontrado");
        }
        var pacientesModel = pacientesID.get();
        BeanUtils.copyProperties(pacientesDto, pacientesModel);
        return ResponseEntity.status(HttpStatus.OK).body(pacientesRepository.save(pacientesModel));
    }

    @Operation(summary = "Deleta uma entidade dos banco de dados dos medicos.", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medico delatado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao apagar"),
            @ApiResponse(responseCode = "404", description = "Medico nao encontrado")
    })
    @DeleteMapping("deletarPaciente/{id}")
    public ResponseEntity<Object>deletePaciente(@PathVariable(value = "id") Integer id) {
        Optional<PacientesModel> pacientesID = pacientesRepository.findById(id);
        if (pacientesID.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente nao encontrado");
        pacientesRepository.delete(pacientesID.get());
        return ResponseEntity.status(HttpStatus.OK).body("Paciente deletado com sucesso");
    }
}
