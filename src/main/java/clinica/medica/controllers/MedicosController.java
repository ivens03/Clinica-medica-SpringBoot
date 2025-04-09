package clinica.medica.controllers;

import clinica.medica.dtos.MedicosDto;
import clinica.medica.models.MedicosModel;
import clinica.medica.repositories.MedicosRepository;
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
@Tag(name = "Medicos", description = "Controller Responsavel Pelo CRUD Medicos")
public class MedicosController {

    @Autowired
    MedicosRepository medicosRepository;

    @Operation(summary = "Cadastrar Medicos", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Salvo no DB com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar"),
            @ApiResponse(responseCode = "422", description = "Dados para que possa ser salvo são inválidos")
    })
    @PostMapping("/medicos")
    public ResponseEntity<MedicosModel> saveMedicos(@RequestBody @Valid MedicosDto medicosDto) {
        var medicosModel = new MedicosModel();
        BeanUtils.copyProperties(medicosDto, medicosModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicosRepository.save(medicosModel));
    }

    @Operation(summary = "Pega toda base de dados dos medicos.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorno de todos os medicos feito com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao encontrar todos os medicos")
    })
    @GetMapping("/medicos")
    public ResponseEntity<List<MedicosModel>> getAllMedicos() {
        List<MedicosModel> medicosList = medicosRepository.findAll();
        if (!medicosList.isEmpty()) {
            for(MedicosModel medicos : medicosList) {
                Integer id = medicos.getIdMedico();
                medicos.add(linkTo(methodOn(MedicosController.class).getOneMedico(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(medicosList);
    }

    @Operation(summary = "Pega uma entidade dos banco de dados dos medicos.", method = "GET")
    @GetMapping("/medicos/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorno feito com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao encontrar o medico")
    })
    public ResponseEntity<Object>getOneMedico(@PathVariable(value = "id") Integer id) {
        Optional<MedicosModel> medicoID = medicosRepository.findById(id);
        if (medicoID.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico não encontrado");
        }
        medicoID.get().add(linkTo(methodOn(MedicosController.class).getAllMedicos()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(medicoID.get());
    }

    @Operation(summary = "Atualiza uma entidade dos banco de dados dos medicos.", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização feito com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar"),
            @ApiResponse(responseCode = "422", description = "Dados para requisição inválidos")
    })
    @PutMapping("medicosAtualizarcao/{id}")
    public ResponseEntity<Object>updateMedico(@PathVariable(value = "id") Integer id, @RequestBody @Valid MedicosDto medicosDto) {
        Optional<MedicosModel> medicoID = medicosRepository.findById(id);
        if (medicoID.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico nao encontrado");
        }
        var medicoModel = medicoID.get();
        BeanUtils.copyProperties(medicosDto, medicoModel);
        return ResponseEntity.status(HttpStatus.OK).body(medicosRepository.save(medicoModel));
    }

    @Operation(summary = "Deleta uma entidade dos banco de dados dos medicos.", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medico delatado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao apagar"),
            @ApiResponse(responseCode = "404", description = "Medico nao encontrado")
    })
    @DeleteMapping("deletarMedico/{id}")
    public ResponseEntity<Object>deleteMedico(@PathVariable(value = "id") Integer id) {
        Optional<MedicosModel> medicoID = medicosRepository.findById(id);
        if (medicoID.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico não encontrato");
        }
        medicosRepository.delete(medicoID.get());
        return ResponseEntity.status(HttpStatus.OK).body("Medico deletado com sucesso");
    }
}
