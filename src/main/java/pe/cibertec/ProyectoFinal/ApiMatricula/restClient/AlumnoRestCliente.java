package pe.cibertec.ProyectoFinal.ApiMatricula.restClient;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Alumno;

@FeignClient (value = "alumno-service", url = "http://localhost:8081/")

public interface AlumnoRestCliente {
    
    @GetMapping ("api/v1/alumno/findByCodigoA/{codigoA}")
    
    Alumno findByCodigoA (@PathVariable Long codigoA);
    
    @GetMapping ("api/v1/alumno/findAll")
    
    List<Alumno> findAllAlumno();
    
    
}
