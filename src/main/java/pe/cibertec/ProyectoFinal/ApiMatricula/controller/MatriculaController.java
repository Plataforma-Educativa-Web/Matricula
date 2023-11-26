package pe.cibertec.ProyectoFinal.ApiMatricula.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.ApiMatricula.dto.MatriculaDTO;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Matricula;
import pe.cibertec.ProyectoFinal.ApiMatricula.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.ApiMatricula.service.MatriculaService;

@RestController
@RequestMapping("api/v1/matricula")
@Slf4j

public class MatriculaController {

    @Autowired

    private MatriculaService matriculaService;

    @GetMapping("/findAll")

    public ResponseEntity<List<Matricula>> findAll() {

        try {
            log.info("Endpoint: /api/v1/matricula/findAll - Buscando todas las matrículas");
            List<Matricula> matriculas = matriculaService.findAll();
            return new ResponseEntity<>(matriculas, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar todas las matrículas: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/buscarPorId/{id}")

    public ResponseEntity<Matricula> buscarPorId(@PathVariable Long id) {

        try {
            log.info("Endpoint: /api/v1/matricula/buscarPorId/{} - Buscando matrícula por ID: {}", id, id);
            Matricula matricula = matriculaService.buscarPorId(id);
            return new ResponseEntity<>(matricula, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar matrícula por ID {}: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/findById/{id}")

    public ResponseEntity<MatriculaDTO> findById(@PathVariable Long id) {

        try {
            log.info("Endpoint: /api/v1/matricula/findById/{} - Buscando matrícula y detalles por ID: {}", id, id);
            MatriculaDTO matriculaDTO = matriculaService.findById(id);
            return new ResponseEntity<>(matriculaDTO, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar matrícula por ID {}: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/agregarMatricula")

    public ResponseEntity<Matricula> agregarMatricula(@RequestBody Matricula matricula) {

        try {
            log.info("Endpoint: /api/v1/matricula/agregarMatricula - Agregando nueva matrícula: {}", matricula);
            Matricula nuevaMatricula = matriculaService.agregarMatricula(matricula);
            return new ResponseEntity<>(nuevaMatricula, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al agregar nueva matrícula: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/actulizarMatricula")

    public ResponseEntity<Matricula> actualizarMatricula(@RequestBody Matricula matricula) {

        try {
            log.info("Endpoint: /api/v1/matricula/actualizarMatricula - Actualizando matrícula con ID {}: {}", matricula.getId(), matricula);
            Matricula matriculaActualizada = matriculaService.actualizarMatricula(matricula);
            return new ResponseEntity<>(matriculaActualizada, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al actualizar matrícula con ID {}: {}", matricula.getId(), e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/eliminarMatricula")

    public void eliminarMatricula(@PathVariable Long id) {

        try {
            log.info("Endpoint: /api/v1/matricula/eliminarMatricula/{} - Eliminando matrícula con ID: {}", id, id);
            matriculaService.eliminarMatricula(id);
            log.info("Matrícula eliminada correctamente");
        } catch (EntityNotFoundException e) {
            log.error("Error al eliminar matrícula con ID {}: {}", id, e.getMessage());
        }

    }
}
