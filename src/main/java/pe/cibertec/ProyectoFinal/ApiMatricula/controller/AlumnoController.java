package pe.cibertec.ProyectoFinal.ApiMatricula.controller;

import java.util.List;
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

public class AlumnoController {

    @Autowired

    private AlumnoRestCliente alumnoRestClient;

    @GetMapping("/findAllAlumno")

    public ResponseEntity<List<Alumno>> findAllAlumno() {

        return new ResponseEntity<>(alumnoRestClient.findAllAlumno(), HttpStatus.OK);

    }

}
