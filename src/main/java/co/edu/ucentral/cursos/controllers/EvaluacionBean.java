/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.cursos.controllers;

import co.edu.ucentral.cursos.models.Curso;
import co.edu.ucentral.cursos.models.Evaluacion;
import co.edu.ucentral.cursos.models.Pregunta;
import co.edu.ucentral.ventasapp.interfaz.ICursoService;
import co.edu.ucentral.ventasapp.interfaz.IEvaluacionService;
import java.io.Serializable;
import java.util.List;
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
    
    int CursoId;
    
    @Inject
    IEvaluacionService evaluacionSvc;
    
    @Inject
    ICursoService cursoService;
    
    
    public String cargarEvaluacion(int cursoId){
        this.evaluacionActual = this.evaluacionSvc.ObtenerEvaluacionCurso(cursoId);
        if(this.evaluacionActual == null)
            this.evaluacionActual = new Evaluacion();
            
        return "editarEvaluacion";
    }
    
    public String nuevaEvaluacion(int cursoid){
        this.evaluacionActual = new Evaluacion();
        this.CursoId = cursoid;
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
    
    public void agregarPregunta(){
    
    }
    
    public void eliminarPregunta(){
    
    }
    
    
}
