/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.cursos.controllers;

import co.edu.ucentral.cursos.models.Curso;
import co.edu.ucentral.cursos.models.CursoInscrito;
import co.edu.ucentral.cursos.models.Estudiante;
import co.edu.ucentral.cursos.models.Evaluacion;
import co.edu.ucentral.cursos.models.EvaluacionRealizada;
import co.edu.ucentral.cursos.models.Pregunta;
import co.edu.ucentral.cursos.models.Respuesta;
import co.edu.ucentral.ventasapp.interfaz.ICursoInscritoService;
import co.edu.ucentral.ventasapp.interfaz.ICursoService;
import co.edu.ucentral.ventasapp.interfaz.IEvaluacionRealizadaService;
import co.edu.ucentral.ventasapp.interfaz.IEvaluacionService;
import co.edu.ucentral.ventasapp.interfaz.IPreguntaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named("evaluacionBean")
@SessionScoped
public class EvaluacionBean implements Serializable {
    
    private Evaluacion evaluacionActual;
    
    private Pregunta preguntaActual;
    private Estudiante estudiante;
    
    private int CursoInscritoId;
    
    int CursoId;
    
    @Inject
    IEvaluacionService evaluacionSvc;
    
    @Inject
    ICursoService cursoService;
    
    @Inject
    IPreguntaService preguntaService;
    
    @Inject
    IEvaluacionRealizadaService evaluacionRealizadaService;
    
    @Inject
    ICursoInscritoService cursoInscritoService;
    
    @PostConstruct
    public  void inicializar(){
        Pregunta p = new Pregunta();
        List<Respuesta> lista = new ArrayList<>();
        
        for(int i = 0; i < 4; i++)
            lista.add(Respuesta.nuevaRespuesta(p));
        
        p.setRespuestaList(lista);
        this.setPreguntaActual(p);
    }
    
    public String cargarEvaluacion(int cursoId){
        this.CursoId = cursoId;
        this.evaluacionActual = this.evaluacionSvc.ObtenerEvaluacionCurso(cursoId);
        if(this.evaluacionActual == null)
            this.evaluacionActual = new Evaluacion();
            
        return "editarEvaluacion";
    }
    
    public String presentarEvaluacion(int cursoId, int cursoInscritoId){
        CursoInscritoId = cursoInscritoId;
        evaluacionActual = this.evaluacionSvc.ObtenerEvaluacionCurso(cursoId);
        evaluacionActual.getPreguntaList().forEach(p -> p.getRespuestaList().forEach(r -> r.setRespuestaCorrecta(false)));
        return "presentarEvaluacion";
    }
    
    public String calificarEvaluacion(){
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        
        estudiante = (Estudiante)sessionMap.get("estudiante");
        
        Evaluacion evaluacion = this.evaluacionSvc.ObtenerPorId(evaluacionActual.getEvaluacionId());
        
        int puntos = 0;
        for(int i = 0; i < evaluacion.getPreguntaList().size();i++){
            List<Respuesta> respuestasCorrectas = evaluacion.getPreguntaList().get(i).getRespuestaList();
            List<Respuesta> respuestasAlumno = evaluacionActual.getPreguntaList().get(i).getRespuestaList();
            
            Boolean respuestaEsCorrecta = true;
            for(int j = 0; j < respuestasCorrectas.size();j++){
                respuestaEsCorrecta = respuestasAlumno.get(j).getRespuestaCorrecta() == respuestasCorrectas.get(j).getRespuestaCorrecta();
                if(!respuestaEsCorrecta)
                    j = respuestasCorrectas.size(); //rompe ciclo
            }
            if(respuestaEsCorrecta)
                puntos++;
        }
        
        double nota = ((double)5 / evaluacion.getPreguntaList().size()) * puntos;
        
        CursoInscrito c = cursoInscritoService.find(CursoInscritoId);
        EvaluacionRealizada eva = new EvaluacionRealizada();
        eva.setCursoInscrito(c);
        eva.setNota(nota);
        eva.setEvaluacion(evaluacion);
        this.evaluacionRealizadaService.insertar(eva);
        
        if(nota < 3.0)
        {
            //pierde
             return "evaluacionDesaprobada";
        }
        else
        {
            //pasa
             return "evaluacionAprobada";
        }
    }
    
    //GET SET

    
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    
    public Evaluacion getEvaluacionActual() {
        return evaluacionActual;
    }

    public void setEvaluacionActual(Evaluacion evaluacionActual) {
        this.evaluacionActual = evaluacionActual;
    }
    
    public String guardarEvaluacion(){
        if(evaluacionActual.getEvaluacionId() == null)
        {
            Curso curso = this.cursoService.encontrarCursoPorId(CursoId);
            this.evaluacionActual.setCurso(curso);
            this.evaluacionActual = this.evaluacionSvc.CrearEvaluacion(evaluacionActual);
        }
        else
            this.evaluacionActual = this.evaluacionSvc.ActualizarEvaluacion(evaluacionActual);
        
        return "editarEvaluacion";
    }
    
    public String agregarPregunta(){
        this.preguntaActual.setEvaluacion(evaluacionActual);
        this.preguntaActual = this.preguntaService.CrearPregunta(preguntaActual);
        return cargarEvaluacion(CursoId);
    }
    
    public void eliminarPregunta(){
    
    }

    /**
     * @return the preguntaActual
     */
    public Pregunta getPreguntaActual() {
        return preguntaActual;
    }

    /**
     * @param preguntaActual the preguntaActual to set
     */
    public void setPreguntaActual(Pregunta preguntaActual) {
        this.preguntaActual = preguntaActual;
    }
    
    
}
