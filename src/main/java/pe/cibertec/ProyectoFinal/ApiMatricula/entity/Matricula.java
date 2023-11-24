package pe.cibertec.ProyectoFinal.ApiMatricula.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Data;

@Data
@Entity

public class Matricula {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    
    private Long id;
    private Date fecha;
    private Long codigoA;
    private Long codigoC;
    private Long codigo;
    private String nombreH;
    private Long codigoP;
    private Long codigoS;
    
}
