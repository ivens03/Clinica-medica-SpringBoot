package clinica.medica.services;

import clinica.medica.models.MedicosModel;
import clinica.medica.repositories.MedicosRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicosServices {

    private MedicosRepository medicosRepository;

    public MedicosServices(MedicosRepository medicosRepository) {
        this.medicosRepository = medicosRepository;
    }

    public MedicosModel create(MedicosModel medico) {
        return medicosRepository.save(medico);
    }

    public MedicosModel update(MedicosModel medico) {
        return medicosRepository.save(medico);
    }

    public void delete(MedicosModel medico) {
        medicosRepository.delete(medico);
    }

}