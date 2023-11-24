package pe.cibertec.ProyectoFinal.ApiMatricula.controller;

import java.util.List;
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

public class ProfesorController {

    @Autowired

    private ProfesorRestCliente profesorRestClient;

    @GetMapping("/findAllProfesor")

    public ResponseEntity<List<Profesor>> findAllProfesor() {

        return new ResponseEntity<>(profesorRestClient.findAllProfesor(), HttpStatus.OK);

    }

}
