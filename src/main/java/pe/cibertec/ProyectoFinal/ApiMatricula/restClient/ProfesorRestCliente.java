package pe.cibertec.ProyectoFinal.ApiMatricula.restClient;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Profesor;

@FeignClient (value = "profesor-service", url = "http://localhost:8084/")

public interface ProfesorRestCliente {
    
    @GetMapping("api/v1/profesor/findByCodigoP/{codigoP}")
    
    Profesor findByCodigoP(@PathVariable Long codigoP);
    
    @GetMapping("api/v1/profesor/findAll")
    
    List<Profesor> findAllProfesor();
    
}
