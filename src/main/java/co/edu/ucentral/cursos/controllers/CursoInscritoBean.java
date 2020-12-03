package co.edu.ucentral.cursos.controllers;

import co.edu.ucentral.cursos.exceptions.NoPuedeInscribirException;
import co.edu.ucentral.cursos.models.Curso;
import co.edu.ucentral.cursos.models.CursoInscrito;
import co.edu.ucentral.cursos.models.Estudiante;
import co.edu.ucentral.ventasapp.interfaz.ICursoInscritoService;
import co.edu.ucentral.ventasapp.interfaz.ICursoService;
import co.edu.ucentral.ventasapp.interfaz.IEstudianteService;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named("cursoInscritoBean")
@SessionScoped
public class CursoInscritoBean implements Serializable{
    
    private Curso curso;
    private List<CursoInscrito> cursosInscritos;
    private Estudiante estudiante;
    
    @Inject
    private ICursoService cursoService;
    
    @Inject
    private ICursoInscritoService cursoInscritoService;
    
    @Inject
    private IEstudianteService estudianteService ;
    
    public String cargarCursosInscritos(){
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        
        estudiante = (Estudiante)sessionMap.get("estudiante");
        this.cursoInscritoService.listarCursos(estudiante.getEstudianteId());

        return "cursosInscritos";
    }

    
    //metodo incribir curso que recibe los id curso y estudiate
    public String inscribirCurso(int idCurso){     
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
   
        curso=this.cursoService.encontrarCursoPorId(idCurso);
        estudiante = (Estudiante)sessionMap.get("estudiante");
        try {
            this.cursoInscritoService.IncribirCurso(curso, estudiante);
        } catch (NoPuedeInscribirException e) {
           return "noPuedeInscribirCurso";  
        }
       return "cursosInscritos";
    }
    
    
    //metodos Get y Set
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<CursoInscrito> getCursosInscritos() {
        return cursosInscritos;
    }

    public void setCursosInscritos(List<CursoInscrito> cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }
    
    
    
}
