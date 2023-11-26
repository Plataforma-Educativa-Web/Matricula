package pe.cibertec.ProyectoFinal.ApiMatricula.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Alumno;
import pe.cibertec.ProyectoFinal.ApiMatricula.restClient.AlumnoRestCliente;

@RestController
@RequestMapping("api/v1/alumno")
@Slf4j

public class AlumnoController {

    @Autowired

    private AlumnoRestCliente alumnoRestClient;

    @GetMapping("/findAllAlumno")

    public ResponseEntity<List<Alumno>> findAllAlumno() {

        try {
            log.info("Endpoint: /api/v1/matricula/findAllAlumno - Buscando todos los alumnos");
            List<Alumno> alumnos = alumnoRestClient.findAllAlumno();
            return new ResponseEntity<>(alumnos, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar todos los alumnos: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
