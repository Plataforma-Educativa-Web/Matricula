package pe.cibertec.ProyectoFinal.ApiMatricula.restClient;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Turno;

@FeignClient(value = "turno-service", url = "http://localhost:8085/")

public interface TurnoRestCliente {

    @GetMapping("api/v1/turno/findByNombre/{nombreH}")

    Turno findByNombre(@PathVariable String nombreH);

    @GetMapping("api/v1/turno/findAll")

    List<Turno> findAllTurno();
}
