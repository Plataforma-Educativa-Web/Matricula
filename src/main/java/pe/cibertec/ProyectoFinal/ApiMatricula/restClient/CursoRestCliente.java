package pe.cibertec.ProyectoFinal.ApiMatricula.restClient;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Curso;

@FeignClient(value = "curso-service", url = "http://localhost:8085/")

public interface CursoRestCliente {

    @GetMapping("api/v1/curso/findByCodigo/{codigo}")
    Curso findByCodigo(@PathVariable Long codigo);

    @GetMapping("/api/v1/curso/findAll")
    List<Curso> findAllCurso();

}
