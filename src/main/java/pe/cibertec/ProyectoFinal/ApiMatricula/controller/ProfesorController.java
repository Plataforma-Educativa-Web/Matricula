package pe.cibertec.ProyectoFinal.ApiMatricula.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Profesor;
import pe.cibertec.ProyectoFinal.ApiMatricula.restClient.ProfesorRestCliente;

@RestController
@RequestMapping("api/v1/profesor")
@Slf4j

public class ProfesorController {

    @Autowired

    private ProfesorRestCliente profesorRestClient;

    @GetMapping("/findAllProfesor")

    public ResponseEntity<List<Profesor>> findAllProfesor() {

        try {
            log.info("Endpoint: /api/v1/matricula/findAllProfesor - Buscando todos los profesores");
            List<Profesor> profesores = profesorRestClient.findAllProfesor();
            return new ResponseEntity<>(profesores, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar todos los profesores: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
