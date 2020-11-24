package co.edu.ucentral.cursos.controllers;

import co.edu.ucentral.cursos.models.Curso;
import co.edu.ucentral.cursos.models.Departamento;
import co.edu.ucentral.cursos.models.Facultad;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import co.edu.ucentral.ventasapp.interfaz.ICursoService;
import co.edu.ucentral.ventasapp.interfaz.IDepartamentoService;
import co.edu.ucentral.ventasapp.interfaz.IFacultadService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;



@Named("cursoBean")
@ViewScoped
public class CursoBean implements Serializable{
    
    @Inject
    private ICursoService cursoService;
    
    @Inject
    private IFacultadService facultadService;
    
    @Inject
    private IDepartamentoService departamentoService;
    
    private int facultadSeleccionada;
    private int departamentoSeleccionado;
    private List<Facultad>faculdesDisponibles;
    private List<Departamento> departamentoDisponibles;
    private Curso curso;
    private List<Curso>cursos;
     
    //*****NOTACION PARA Q SIEMPRE SE EJECUTE ESTE METODO
    @PostConstruct
    public  void inicializar(){
       // CursoFachada.CrearCurso("Matematicas", "Curso de matematicas avanzada", Boolean.FALSE, Boolean.TRUE, 72);
       cursos = cursoService.listarCursos();
       curso = new Curso();
       faculdesDisponibles = facultadService.listarFacultades();
       
    }
    
    public void cambioFacultad(AjaxBehaviorEvent event){
        departamentoDisponibles = departamentoService.listarDepartamentosPorFacultad(facultadSeleccionada);
    }
   
    public String nuevoCurso(){
       this.curso=new Curso();
       return "nuevoCurso";
    }
   
    public String guardarCurso(){
        Departamento departamento = departamentoService.ObtenerPorId(departamentoSeleccionado);
        curso.setDepartamento(departamento);
        this.cursoService.guardarCurso(curso);
        this.cursos.add(curso);
        //this.curso=null;
        return "listadoCursos";
    }
    
    public String editar(int CursoId){
        curso = new Curso();
        curso.setCursoId(CursoId);
        curso=this.cursoService.encontrarCursoPorId(CursoId);
        return "edicionCurso";
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

    public ICursoService getCursoService() {
        return cursoService;
    }

    public void setCursoService(ICursoService cursoService) {
        this.cursoService = cursoService;
    }

    public IFacultadService getFacultadService() {
        return facultadService;
    }

    public void setFacultadService(IFacultadService facultadService) {
        this.facultadService = facultadService;
    }

    public IDepartamentoService getDepartamentoService() {
        return departamentoService;
    }

    public void setDepartamentoService(IDepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    public int getFacultadSeleccionada() {
        return facultadSeleccionada;
    }

    public void setFacultadSeleccionada(int facultadSeleccionada) {
        this.facultadSeleccionada = facultadSeleccionada;
    }

    public int getDepartamentoSeleccionado() {
        return departamentoSeleccionado;
    }

    public void setDepartamentoSeleccionado(int departamentoSeleccionado) {
        this.departamentoSeleccionado = departamentoSeleccionado;
    }

    public List<Facultad> getFaculdesDisponibles() {
        return faculdesDisponibles;
    }

    public void setFaculdesDisponibles(List<Facultad> faculdesDisponibles) {
        this.faculdesDisponibles = faculdesDisponibles;
    }

    public List<Departamento> getDepartamentoDisponibles() {
        return departamentoDisponibles;
    }

    public void setDepartamentoDisponibles(List<Departamento> departamentoDisponibles) {
        this.departamentoDisponibles = departamentoDisponibles;
    }

    
   
}
