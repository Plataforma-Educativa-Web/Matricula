package pe.cibertec.ProyectoFinal.ApiMatricula.service;

import java.util.List;
import pe.cibertec.ProyectoFinal.ApiMatricula.dto.MatriculaDTO;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Matricula;

public interface MatriculaService {

    public List<Matricula> findAll();

    public Matricula buscarPorId(Long id);

    public MatriculaDTO findById(Long id);

    public Matricula agregarMatricula(Matricula matricula);

    public Matricula actualizarMatricula(Matricula matricula);

    public void eliminarMatricula(Long id);
}
