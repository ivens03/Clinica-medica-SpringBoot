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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
