package pe.cibertec.ProyectoFinal.ApiMatricula.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j

public class CursoController {

    @Autowired

    private CursoRestCliente apiRestClient;

    @GetMapping("/findAllCurso")

    public ResponseEntity<List<Curso>> findAllCurso() {

        try {
            log.info("Endpoint: /api/v1/matricula/findAllCurso - Buscando todos los cursos");
            List<Curso> cursos = apiRestClient.findAllCurso();
            return new ResponseEntity<>(cursos, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar todos los cursos: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
