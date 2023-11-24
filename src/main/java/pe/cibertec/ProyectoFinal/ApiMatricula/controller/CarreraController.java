package pe.cibertec.ProyectoFinal.ApiMatricula.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Carrera;
import pe.cibertec.ProyectoFinal.ApiMatricula.restClient.CarreraRestCliente;

public class CarreraController {

    @Autowired

    private CarreraRestCliente carreraRestClient;

    @GetMapping("/findAllCarrera")

    public ResponseEntity<List<Carrera>> findAllCarrera() {

        return new ResponseEntity<>(carreraRestClient.findAllCarrera(), HttpStatus.OK);

    }
}
