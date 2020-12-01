/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.cursos.controllers;

import co.edu.ucentral.cursos.models.Curso;
import co.edu.ucentral.cursos.models.Docente;
import co.edu.ucentral.cursos.models.Estudiante;
import co.edu.ucentral.cursos.models.Evaluacion;
import co.edu.ucentral.cursos.models.Pregunta;
import co.edu.ucentral.cursos.models.Respuesta;
import co.edu.ucentral.ventasapp.interfaz.ICursoService;
import co.edu.ucentral.ventasapp.interfaz.IDocenteService;
import co.edu.ucentral.ventasapp.interfaz.IEstudianteService;
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
@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    
    Docente docente;
    Estudiante estudiante;
    
    int UsuarioID;
    String password;
    
    @Inject
    IDocenteService docenteService ;
    
    @Inject
    IEstudianteService estudianteService;
    
    public String acceso(){
        docente = docenteService.ObtenerPorId(this.UsuarioID);
        if(docente.getDocenteId() > 0){
            if(docente.getClave().equals(this.password)){
                return "indexPrincipal";
            }      
        }else{
            estudiante = estudianteService.ObtenerPorId(this.UsuarioID);
            if(estudiante.getEstudianteId()> 0){
                if(estudiante.getClave().equals(this.password)){
                    return "indexPrincipalEstudiante";
                }
            }else{
                return "index";
            }      
        }
        return "index";
    }

    //get y set
    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public int getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(int UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
