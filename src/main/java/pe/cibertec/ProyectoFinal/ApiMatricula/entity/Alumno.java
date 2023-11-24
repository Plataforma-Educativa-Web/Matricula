package pe.cibertec.ProyectoFinal.ApiMatricula.entity;

import lombok.Data;

@Data

public class Alumno {

    private Long id;
    private Long codigoA;
    private String nombre;
    private String apellido;
    private Long dni;
    private String sexo;
    private String email;
    private String edad;
    private String celular;

}
