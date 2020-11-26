/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.cursos.controllers;

import co.edu.ucentral.cursos.models.Evaluacion;
import co.edu.ucentral.cursos.models.Pregunta;
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
    
    @Inject
    IEvaluacionService evaluacionSvc;
    
     private List<Pregunta>preguntas;
    
    public String cargarEvaluacion(int evaluacionId){
        this.evaluacionActual = this.evaluacionSvc.ObtenerPorId(evaluacionId);
        return "editarEvaluacion";
    }
    
    public String nuevaEvaluacion(int cursoid){
        this.evaluacionActual = new Evaluacion();
        return "nuevaEvaluacion";
    }
    
    //GET SET

    public Evaluacion getEvaluacionActual() {
        return evaluacionActual;
    }

    public void setEvaluacionActual(Evaluacion evaluacionActual) {
        this.evaluacionActual = evaluacionActual;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
    
    
}
