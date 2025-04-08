package clinica.medica.controllers;

import clinica.medica.dtos.MedicosDto;
import clinica.medica.models.MedicosModel;
import clinica.medica.repositories.MedicosRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Medicos", description = "Controller Responsavel Pelo CRUD Medicos")
public class MedicosController {

    @Autowired
    MedicosRepository medicosRepository;

    @Operation(summary = "Cadastrar Medicos", method = "POST")
    @PostMapping("/medicos")
    public ResponseEntity<MedicosModel> saveMedicos(@RequestBody @Valid MedicosDto medicosDto) {
        var medicosModel = new MedicosModel();
        BeanUtils.copyProperties(medicosDto, medicosModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicosRepository.save(medicosModel));
    }

    @Operation(summary = "Pega toda base de dados dos medicos.", method = "GET")
    @GetMapping("/medicos")
    public ResponseEntity<List<MedicosModel>> getAllMedicos() {
        return ResponseEntity.status(HttpStatus.OK).body(medicosRepository.findAll());
    }

    @Operation(summary = "Pega uma entidade dos banco de dados dos medicos.", method = "GET")
    @GetMapping("/medicos/{id}")
    public ResponseEntity<Object>getOneMedico(@PathVariable(value = "id") Integer id) {
        Optional<MedicosModel> medicoID = medicosRepository.findById(id);
        if (medicoID.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(medicoID.get());
    }

}
