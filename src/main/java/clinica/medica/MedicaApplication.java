package clinica.medica;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Clinica Medica",
		version = "1.0",
		description = "Documentação das APIs do projeto Clinica Medica"))
public class MedicaApplication {
	public static void main(String[] args) {
		SpringApplication.run(MedicaApplication.class, args);
	}

}
