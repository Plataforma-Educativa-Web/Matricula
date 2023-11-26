package pe.cibertec.ProyectoFinal.ApiMatricula.serviceImpl;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ProyectoFinal.ApiMatricula.dao.MatriculaRepository;
import pe.cibertec.ProyectoFinal.ApiMatricula.dto.MatriculaDTO;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Alumno;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Carrera;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Curso;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Matricula;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Profesor;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Sede;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Turno;
import pe.cibertec.ProyectoFinal.ApiMatricula.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.ApiMatricula.restClient.AlumnoRestCliente;
import pe.cibertec.ProyectoFinal.ApiMatricula.restClient.CarreraRestCliente;
import pe.cibertec.ProyectoFinal.ApiMatricula.restClient.CursoRestCliente;
import pe.cibertec.ProyectoFinal.ApiMatricula.service.MatriculaService;
import pe.cibertec.ProyectoFinal.ApiMatricula.restClient.ProfesorRestCliente;
import pe.cibertec.ProyectoFinal.ApiMatricula.restClient.SedeRestCliente;
import pe.cibertec.ProyectoFinal.ApiMatricula.restClient.TurnoRestCliente;

@Service
@Slf4j

public class MatriculaServiceImpl implements MatriculaService {

    @Autowired

    private MatriculaRepository matriculaRepository;

    @Autowired

    private AlumnoRestCliente alumnoRestCliente;

    @Autowired

    private CarreraRestCliente carreraRestCliente;

    @Autowired

    private CursoRestCliente cursoRestCliente;

    @Autowired

    private ProfesorRestCliente profesorRestCliente;

    @Autowired

    private SedeRestCliente sedeRestCliente;

    @Autowired

    private TurnoRestCliente turnoRestCliente;

    @Override
    public List<Matricula> findAll() {
        log.info("Buscando todas las matrículas");

        return (List<Matricula>) matriculaRepository.findAll();

    }

    public List<Alumno> findAllAlumno() {
        log.info("Buscando todos los alumnos");

        return (List<Alumno>) alumnoRestCliente.findAllAlumno();

    }

    public List<Carrera> findAllCarrera() {
        log.info("Buscando todas las carreras");

        return (List<Carrera>) carreraRestCliente.findAllCarrera();

    }

    public List<Curso> findAllCurso() {
        log.info("Buscando todos los cursos");

        return (List<Curso>) cursoRestCliente.findAllCurso();

    }

    public List<Profesor> findAllProfesor() {
        log.info("Buscando todos los profesores");

        return (List<Profesor>) profesorRestCliente.findAllProfesor();

    }

    public List<Sede> findAllSede() {
        log.info("Buscando todas las sedes");

        return (List<Sede>) sedeRestCliente.findAllSede();

    }

    public List<Turno> findAllTurno() {
        log.info("Buscando todos los turnos");

        return (List<Turno>) turnoRestCliente.findAllTurno();

    }

    @Override
    public Matricula buscarPorId(Long id) {
        log.info("Buscando matrícula por ID: {}", id);

        return matriculaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Matricula no encontrada con el id" + id.toString()));

    }

    @Override
    public MatriculaDTO findById(Long id) {
        log.info("Buscando matrícula y detalles por ID: {}", id);

        Matricula matricula = matriculaRepository.findById(id).get();

        Alumno alumno = alumnoRestCliente.findByCodigoA(matricula.getCodigoA());
        Carrera carrera = carreraRestCliente.findByCodigoC(matricula.getCodigoC());
        Curso curso = cursoRestCliente.findByCodigo(matricula.getCodigo());
        Profesor profesor = profesorRestCliente.findByCodigoP(matricula.getCodigoP());
        Sede sede = sedeRestCliente.findByCodigoS(matricula.getCodigoS());
        Turno turno = turnoRestCliente.findByNombre(matricula.getNombreH());

        MatriculaDTO matriculaDTO = new MatriculaDTO();

        matriculaDTO.setId(matricula.getId());
        matriculaDTO.setFecha(matricula.getFecha());
        matriculaDTO.setAlumno(alumno);
        matriculaDTO.setCarrera(carrera);
        matriculaDTO.setCurso(curso);
        matriculaDTO.setProfesor(profesor);
        matriculaDTO.setSede(sede);
        matriculaDTO.setTurno(turno);

        return matriculaDTO;

    }

    @Override
    public Matricula agregarMatricula(Matricula matricula) {

        log.info("Agregando nueva matrícula: {}", matricula);
        return matriculaRepository.save(matricula);

    }

    @Override
    public Matricula actualizarMatricula(Matricula matricula) {

        log.info("Actualizando matrícula con ID {}: {}", matricula.getId(), matricula);
        var MatriculaF = matriculaRepository.findById(matricula.getId()).get();
        MatriculaF.setFecha(matricula.getFecha());
        MatriculaF.setCodigoA(matricula.getCodigoA());
        MatriculaF.setCodigoC(matricula.getCodigoC());
        MatriculaF.setCodigo(matricula.getCodigo());
        MatriculaF.setNombreH(matricula.getNombreH());
        MatriculaF.setCodigoP(matricula.getCodigoP());
        MatriculaF.setCodigoS(matricula.getCodigoS());

        return matriculaRepository.save(MatriculaF);

    }

    @Override
    public void eliminarMatricula(Long id) {

        log.info("Eliminando matrícula con ID: {}", id);
        var MatriculaF = matriculaRepository.findById(id).get();
        matriculaRepository.delete(MatriculaF);

    }

}
