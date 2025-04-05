package clinica.medica.repositories;

import clinica.medica.models.MedicosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicosRepository extends JpaRepository<MedicosModel, Integer> {
}
