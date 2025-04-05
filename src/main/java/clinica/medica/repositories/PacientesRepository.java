package clinica.medica.repositories;

import clinica.medica.models.PacientesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientesRepository extends JpaRepository<PacientesModel, Integer> {
}
