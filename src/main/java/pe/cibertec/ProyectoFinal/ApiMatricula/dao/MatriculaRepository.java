package pe.cibertec.ProyectoFinal.ApiMatricula.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
    
}
