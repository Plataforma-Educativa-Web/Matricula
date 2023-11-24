package pe.cibertec.ProyectoFinal.ApiMatricula.controller;

import java.util.List;
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

public class SedeController {

    @Autowired

    private SedeRestCliente sedeRestClient;

    @GetMapping("/findAllSede")

    public ResponseEntity<List<Sede>> findAllSede() {

        return new ResponseEntity<>(sedeRestClient.findAllSede(), HttpStatus.OK);

    }

}
