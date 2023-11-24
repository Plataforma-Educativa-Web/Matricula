package pe.cibertec.ProyectoFinal.ApiMatricula.dto;

import java.util.Date;
import lombok.Data;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Alumno;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Carrera;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Curso;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Profesor;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Sede;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Turno;

@Data

public class MatriculaDTO {

    private Long id;
    private Date fecha;
    private Alumno alumno;
    private Carrera carrera;
    private Curso curso;
    private Profesor profesor;
    private Sede sede;
    private Turno turno;

}