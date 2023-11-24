package pe.cibertec.ProyectoFinal.ApiMatricula.restClient;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Sede;

@FeignClient(value = "sede-service", url = "http://localhost:8084/")

public interface SedeRestCliente {

    @GetMapping("api/v1/sede/findByCodigoS/{codigoS}")

    Sede findByCodigoS(@PathVariable Long codigoS);

    @GetMapping("api/v1/sede/findAll")

    List<Sede> findAllSede();

}
