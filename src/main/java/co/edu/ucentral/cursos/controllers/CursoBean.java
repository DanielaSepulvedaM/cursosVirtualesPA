package co.edu.ucentral.cursos.controllers;

import co.edu.ucentral.cursos.models.Curso;
import co.edu.ucentral.cursos.models.Departamento;
import co.edu.ucentral.cursos.models.Docente;
import co.edu.ucentral.cursos.models.Estado;
import co.edu.ucentral.cursos.models.Facultad;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import co.edu.ucentral.ventasapp.interfaz.ICursoService;
import co.edu.ucentral.ventasapp.interfaz.IDepartamentoService;
import co.edu.ucentral.ventasapp.interfaz.IDocenteService;
import co.edu.ucentral.ventasapp.interfaz.IFacultadService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

@Named("cursoBean")
@SessionScoped
public class CursoBean implements Serializable{
    
    @Inject
    private ICursoService cursoService;
    
    @Inject
    private IFacultadService facultadService;
    
    @Inject
    private IDepartamentoService departamentoService;
    
    @Inject
    private IDocenteService docenteService; 
    
   
    
    private int facultadSeleccionada;
    private int departamentoSeleccionado;
    private int docenteSeleccionado;
    private int estadoSeleccionado;
    private List<Facultad>faculdesDisponibles;
    private List<Departamento> departamentoDisponibles;
    private List<Docente> docentesDisponibles;
    private List<Estado> estadoDisponible;
    private Curso curso;
    private List<Curso>cursos;
    
     
    //*****NOTACION PARA Q SIEMPRE SE EJECUTE ESTE METODO
    @PostConstruct
    public  void inicializar(){
       // CursoFachada.CrearCurso("Matematicas", "Curso de matematicas avanzada", Boolean.FALSE, Boolean.TRUE, 72);
       cursos = cursoService.listarCursos();
       
       if(curso == null)
            curso = new Curso();
       
       faculdesDisponibles = facultadService.listarFacultades();
       docentesDisponibles = docenteService.listarDocentes();
       //estadoDisponible = estadoService.listarEstados();
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
        Docente docente = docenteService.ObtenerPorId(docenteSeleccionado);
        curso.setDocente(docente);
        curso.setDepartamento(departamento);
        this.cursoService.guardarCurso(curso);
        this.cursos.add(curso);
        //this.curso=null;
        return "listadoCursos";
    }
    
    public String editar(int CursoId){
        curso=this.cursoService.encontrarCursoPorId(CursoId);
        facultadSeleccionada = curso.getDepartamento().getFacultad().getFacultadId();
        departamentoSeleccionado = curso.getDepartamento().getDepartamentoId();
        docenteSeleccionado = curso.getDocente().getDocenteId();
        
        if(departamentoDisponibles == null)
        departamentoDisponibles = departamentoService.listarDepartamentosPorFacultad(facultadSeleccionada);
        
        return "edicionCurso";
    }
   
    public String modificarCurso(){
      
        Docente doc = docenteService.ObtenerPorId(docenteSeleccionado);
        curso.setDocente(doc);
        this.cursoService.modificarCurso(curso);
        cursos=cursoService.listarCursos();
        return "listadoCursos";    
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

    public int getDocenteSeleccionado() {
        return docenteSeleccionado;
    }

    public void setDocenteSeleccionado(int docenteSeleccionado) {
        this.docenteSeleccionado = docenteSeleccionado;
    }

    public List<Docente> getDocentesDisponibles() {
        return docentesDisponibles;
    }

    public void setDocentesDisponibles(List<Docente> docentesDisponibles) {
        this.docentesDisponibles = docentesDisponibles;
    }

    public int getEstadoSeleccionado() {
        return estadoSeleccionado;
    }

    public void setEstadoSeleccionado(int estadoSeleccionado) {
        this.estadoSeleccionado = estadoSeleccionado;
    }
    
    
}
