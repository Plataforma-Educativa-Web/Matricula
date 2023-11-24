package pe.cibertec.ProyectoFinal.ApiMatricula.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.ApiMatricula.dto.MatriculaDTO;
import pe.cibertec.ProyectoFinal.ApiMatricula.entity.Matricula;
import pe.cibertec.ProyectoFinal.ApiMatricula.service.MatriculaService;

@RestController
@RequestMapping("api/v1/matricula")

public class MatriculaController {
    
    @Autowired
    
    private MatriculaService matriculaService;
    
    @GetMapping("/findAll")
    
    public ResponseEntity<List<Matricula>> findAll() {
        
        return new ResponseEntity<>(matriculaService.findAll(), HttpStatus.OK);
        
    }
    
    @GetMapping("/buscarPorId/{id}")
    
    public ResponseEntity<Matricula> buscarPorId(@PathVariable Long id) {
        
        return new ResponseEntity<>(matriculaService.buscarPorId(id), HttpStatus.OK);
        
    }
    
    @GetMapping("/findById/{id}")
    
    public ResponseEntity<MatriculaDTO> findById (@PathVariable Long id) {
        
        return new ResponseEntity<>(matriculaService.findById(id), HttpStatus.OK);
        
    }
    
    @PostMapping("/agregarMatricula")
    
    public ResponseEntity<Matricula> agregarMatricula (@RequestBody Matricula matricula) {
        
        return new ResponseEntity<>(matriculaService.agregarMatricula(matricula), HttpStatus.CREATED);
        
    }
    
}
