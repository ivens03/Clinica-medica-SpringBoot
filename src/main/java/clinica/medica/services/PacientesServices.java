package clinica.medica.services;

import clinica.medica.models.PacientesModel;
import clinica.medica.repositories.PacientesRepository;
import org.springframework.stereotype.Service;

@Service
public class PacientesServices {

    private PacientesRepository pacientesRepository;

    public PacientesServices(PacientesRepository pacientesRepository) {
        this.pacientesRepository = pacientesRepository;
    }

    public PacientesModel create(PacientesModel paciente) {
        return pacientesRepository.save(paciente);
    }

    public PacientesModel update(PacientesModel paciente) {
        return pacientesRepository.save(paciente);
    }

    public void delete(PacientesModel paciente) {
        pacientesRepository.delete(paciente);
    }
}
