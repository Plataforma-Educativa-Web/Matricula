package pe.cibertec.ProyectoFinal.ApiMatricula.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Sede;
import pe.cibertec.ProyectoFinal.ApiMatricula.restClient.SedeRestCliente;

@RestController
@RequestMapping("api/v1/sede")
@Slf4j

public class SedeController {

    @Autowired

    private SedeRestCliente sedeRestClient;

    @GetMapping("/findAllSede")

    public ResponseEntity<List<Sede>> findAllSede() {

        try {
            log.info("Endpoint: /api/v1/matricula/findAllSede - Buscando todas las sedes");
            List<Sede> sedes = sedeRestClient.findAllSede();
            return new ResponseEntity<>(sedes, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar todas las sedes: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
