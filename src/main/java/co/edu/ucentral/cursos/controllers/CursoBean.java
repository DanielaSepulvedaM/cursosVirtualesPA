package co.edu.ucentral.cursos.controllers;

import co.edu.ucentral.cursos.models.Curso;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import co.edu.ucentral.ventasapp.interfaz.ICursoService;
import javax.annotation.PostConstruct;



@Named("cursoBean")
@RequestScoped
public class CursoBean {
    
    @Inject
    private ICursoService cursoService;
    
    private Curso curso;
    private List<Curso>cursos;
     
    //*****NOTACION PARA Q SIEMPRE SE EJECUTE ESTE METODO
    @PostConstruct
    public  void inicializar(){
       // CursoFachada.CrearCurso("Matematicas", "Curso de matematicas avanzada", Boolean.FALSE, Boolean.TRUE, 72);
       cursos = cursoService.listarCursos();
       curso = new Curso();
    }
    
   public String nuevoCurso(){
      this.curso=new Curso();
      return "nuevoCurso";
   }
   
   

   //****GET Y SET****
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
   
   
    
}
