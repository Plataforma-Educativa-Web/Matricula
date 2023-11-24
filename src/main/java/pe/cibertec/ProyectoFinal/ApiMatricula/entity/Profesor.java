package pe.cibertec.ProyectoFinal.ApiMatricula.entity;

import lombok.Data;

@Data

public class Profesor {

    private Long id;
    private Long codigoP;
    private String nombre;
    private String apellido;
    private String sexo;
    private String edad;
    private String email;
    private String celular;
}
