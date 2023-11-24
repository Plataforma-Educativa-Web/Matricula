package pe.cibertec.ProyectoFinal.ApiMatricula.controller;

import java.util.List;
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

public class TurnoController {

    @Autowired

    private TurnoRestCliente turnoRestClient;

    @GetMapping("/findAllTurno")

    public ResponseEntity<List<Turno>> findAllTurno() {

        return new ResponseEntity<>(turnoRestClient.findAllTurno(), HttpStatus.OK);

    }

}
