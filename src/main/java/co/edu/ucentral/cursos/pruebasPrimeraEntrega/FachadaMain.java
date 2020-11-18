package co.edu.ucentral.cursos.pruebasPrimeraEntrega;

import co.edu.ucentral.cursos.models.Curso;
import co.edu.ucentral.cursos.models.Departamento;
import co.edu.ucentral.cursos.models.Evaluacion;
import co.edu.ucentral.cursos.models.Facultad;
import co.edu.ucentral.cursos.models.Pregunta;
import co.edu.ucentral.cursos.models.Respuesta;
import java.util.ArrayList;
import org.apache.logging.log4j.*;

public class FachadaMain {
    static Logger log = (Logger) LogManager.getRootLogger();
    public static void main(String[] args) {
        
       //********PRUEBA CREAR UN CURSO********
       //CursoFachada.CrearCurso("Matematicas", "Curso de matematicas avanzada", Boolean.FALSE, Boolean.TRUE, 72);
       
       
       //********PRUEBA CREAR UNA EVALUACION CON PREGUNTAS Y OPCIONES DE RESPUESTA********
       //crear la lista de preguntas
       /*
       ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
             
       Pregunta pre = new Pregunta();
       pre.setTextoPregunta("¿ Como se dice lapiz en ingles 3?");
       preguntas.add(pre);
       
       Pregunta pre1 = new Pregunta();
       pre1.setTextoPregunta("¿ Como se dice libro en ingles 3?");
       preguntas.add(pre1);
       
       Pregunta pre2 = new Pregunta();
       pre2.setTextoPregunta("¿ Como se dice gato en ingles 3?"); 
       preguntas.add(pre2);
       
       //crear la lista de respuestas
       ArrayList<Respuesta> respuestasPP = new ArrayList<Respuesta>();
     
       Respuesta respuestaPP = new Respuesta();      
       respuestaPP.setTextoRespuesta("a) Dog 3");
       respuestaPP.setRespuestaCorrecta(false);
       respuestasPP.add(respuestaPP);
       
       Respuesta respuesta1PP = new Respuesta();
       respuesta1PP.setTextoRespuesta("b) Pencil 3");
       respuesta1PP.setRespuestaCorrecta(true); 
       respuestasPP.add(respuesta1PP);
       
       Respuesta respuesta2PP = new Respuesta();
       respuesta2PP.setTextoRespuesta("c) Book 3");
       respuesta2PP.setRespuestaCorrecta(false);
       respuestasPP.add(respuesta2PP);
       
       Respuesta respuesta3PP = new Respuesta();
       respuesta3PP.setTextoRespuesta("d) Cat 3");
       respuesta3PP.setRespuestaCorrecta(false);
       respuestasPP.add(respuesta3PP);
       
       pre.setRespuestaList(respuestasPP); 
            
       ArrayList<Respuesta> respuestas1TP = new ArrayList<>();
       
       Respuesta respuesta1TP = new Respuesta();
       respuesta1TP.setTextoRespuesta("a) Cat 3");
       respuesta1TP.setRespuestaCorrecta(true);
       respuestas1TP.add(respuesta1TP);
       
       Respuesta respuesta2TP = new Respuesta();
       respuesta2TP.setTextoRespuesta("b) Dog 3");
       respuesta2TP.setRespuestaCorrecta(false);
       respuestas1TP.add(respuesta2TP);

       Respuesta respuesta3TP = new Respuesta();
       respuesta3TP.setTextoRespuesta("c) Cat 3");
       respuesta3TP.setRespuestaCorrecta(false);
       respuestas1TP.add(respuesta3TP);

       Respuesta respuesta4TP = new Respuesta();
       respuesta4TP.setTextoRespuesta("d) Book 3");
       respuesta4TP.setRespuestaCorrecta(false);
       respuestas1TP.add(respuesta4TP);

       pre2.setRespuestaList(respuestas1TP);                   
           
       EvaluacionFachada.CrearEvaluacion("Evaluacion de Ingles 3", preguntas, 3);       
       */       
       
       //********PRUEBA OBTENER UNA EVALUACION DE LA BD ********
       /*
       Evaluacion evaluacion  =  EvaluacionFachada.ObtenerEvaluacion(12);
       evaluacion.getIdevaluacion();
       evaluacion.getCurso();
       evaluacion.getNombreevaluacion();
       evaluacion.getPreguntas();
       
        //tipo de variable qu estoy recorriente
        //nombre a como me voy a referir a cada elemento
        //quien tiene las preguntas en este caso las tiene una evaluacion punto preguntas
        /*
        for(Pregunta pre: evaluacion.preguntas){
            System.out.println("PREGUNTA EVALUACION CREADA: " + pre.textoPregunta);
            for(Respuesta resp: pre.respuestas){
                System.out.println("OPCION DE RESPUESTA: " + resp.textoRespuesta);
            }
        } 
        */
        
        
        //********PRUEBA OBTENER UNA FACULTAD DE LA BD ********
        /*
        Facultad facultad = FacultadFachada.ObtenerFacultad(2);
        facultad.getNombre();
        System.out.println("FACULTAD DE : " + facultad.nombre);
        */
        
        
        //********PRUEBA OBTENER UN DEPARTAMENTO DE LA BD ********
        /*
        Departamento departamento = DepartamentoFachada.ObtenerDepartamento(2);
        facultad.getNombre();
        System.out.println("DEPARTAMENTO DE : " + departamento.nombre);
        */
    }
}
