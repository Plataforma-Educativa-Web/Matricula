package pe.cibertec.ProyectoFinal.ApiMatricula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class ApiMatriculaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMatriculaApplication.class, args);
	}

}
