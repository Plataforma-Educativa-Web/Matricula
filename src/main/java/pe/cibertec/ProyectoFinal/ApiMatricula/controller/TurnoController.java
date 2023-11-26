package pe.cibertec.ProyectoFinal.ApiMatricula.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Turno;
import pe.cibertec.ProyectoFinal.ApiMatricula.restClient.TurnoRestCliente;

@RestController
@RequestMapping("api/v1/turno")
@Slf4j

public class TurnoController {

    @Autowired

    private TurnoRestCliente turnoRestClient;

    @GetMapping("/findAllTurno")

    public ResponseEntity<List<Turno>> findAllTurno() {

        try {
            log.info("Endpoint: /api/v1/matricula/findAllTurno - Buscando todos los turnos");
            List<Turno> turnos = turnoRestClient.findAllTurno();
            return new ResponseEntity<>(turnos, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar todos los turnos: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
