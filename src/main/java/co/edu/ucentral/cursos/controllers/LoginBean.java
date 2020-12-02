package co.edu.ucentral.cursos.controllers;

import co.edu.ucentral.cursos.models.Docente;
import co.edu.ucentral.cursos.models.Estudiante;
import co.edu.ucentral.ventasapp.interfaz.IDocenteService;
import co.edu.ucentral.ventasapp.interfaz.IEstudianteService;
import java.io.Serializable;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    
    private Docente docente;
    private Estudiante estudiante;
    
    //int UsuarioID;
    private String correo;
    private String password;
    
    @Inject
    IDocenteService docenteService;
    
    @Inject
    IEstudianteService estudianteService;
    
    public String acceso(){
        docente = docenteService.ObtenerPorLogin(correo);
        estudiante = estudianteService.ObtenerPorLogin(correo);
        if(docente != null){
            if(docente.getClave().equals(this.password)){
                {
                    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                    Map<String, Object> sessionMap = externalContext.getSessionMap();
                    sessionMap.put("estudiante", estudiante);

                    return "listadoCursos";
                }
            }
        }
        else if(estudiante != null){    
            if(estudiante.getClave().equals(this.password)){
                return "indexPrincipal";
            }
        }
        return "noAutorizado";
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
