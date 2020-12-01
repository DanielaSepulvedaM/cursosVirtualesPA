/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.cursos.controllers;

import co.edu.ucentral.cursos.models.Curso;
import co.edu.ucentral.cursos.models.Evaluacion;
import co.edu.ucentral.cursos.models.Pregunta;
import co.edu.ucentral.cursos.models.Respuesta;
import co.edu.ucentral.ventasapp.interfaz.ICursoService;
import co.edu.ucentral.ventasapp.interfaz.IEvaluacionService;
import co.edu.ucentral.ventasapp.interfaz.IPreguntaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named("evaluacionBean")
@SessionScoped
public class EvaluacionBean implements Serializable {
    
    Evaluacion evaluacionActual;
    private Pregunta preguntaActual;
    
    int CursoId;
    
    @Inject
    IEvaluacionService evaluacionSvc;
    
    @Inject
    ICursoService cursoService;
    
    @Inject
    IPreguntaService preguntaService;
    
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
        this.evaluacionActual = this.evaluacionSvc.ObtenerEvaluacionCurso(cursoId);
        if(this.evaluacionActual == null)
            this.evaluacionActual = new Evaluacion();
            
        return "editarEvaluacion";
    }
    
    //GET SET

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
        this.preguntaService.CrearPregunta(preguntaActual);
        return "editarEvaluacion";
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
