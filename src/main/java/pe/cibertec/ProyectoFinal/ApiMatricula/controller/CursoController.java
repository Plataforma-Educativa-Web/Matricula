package pe.cibertec.ProyectoFinal.ApiMatricula.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Curso;
import pe.cibertec.ProyectoFinal.ApiMatricula.restClient.CursoRestCliente;

@RestController
@RequestMapping("api/v1/curso")

public class CursoController {

    @Autowired

    private CursoRestCliente apiRestClient;

    @GetMapping("/findAllCurso")

    public ResponseEntity<List<Curso>> findAllCurso() {

        return new ResponseEntity<>(apiRestClient.findAllCurso(), HttpStatus.OK);

    }

}
