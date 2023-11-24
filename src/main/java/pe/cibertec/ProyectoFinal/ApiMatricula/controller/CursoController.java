package pe.cibertec.ProyectoFinal.ApiMatricula.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Curso;
import pe.cibertec.ProyectoFinal.ApiMatricula.restClient.CursoRestCliente;

public class CursoController {

    @Autowired

    private CursoRestCliente apiRestClient;

    @GetMapping("/findAllCurso")

    public ResponseEntity<List<Curso>> findAllCurso() {

        return new ResponseEntity<>(apiRestClient.findAllCurso(), HttpStatus.OK);

    }

}