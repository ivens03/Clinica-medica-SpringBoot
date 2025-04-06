package clinica.medica.controllers;

import clinica.medica.repositories.MedicosRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MedicosController {

    @Autowired
    MedicosRepository medicosRepository;
}
