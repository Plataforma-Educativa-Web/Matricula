package pe.cibertec.ProyectoFinal.ApiMatricula.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Carrera;
import pe.cibertec.ProyectoFinal.ApiMatricula.restClient.CarreraRestCliente;

@RestController
@RequestMapping("api/v1/carrera")
@Slf4j

public class CarreraController {

    @Autowired

    private CarreraRestCliente carreraRestClient;

    @GetMapping("/findAllCarrera")

    public ResponseEntity<List<Carrera>> findAllCarrera() {

        try {
            log.info("Endpoint: /api/v1/matricula/findAllCarrera - Buscando todas las carreras");
            List<Carrera> carreras = carreraRestClient.findAllCarrera();
            return new ResponseEntity<>(carreras, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar todas las carreras: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
