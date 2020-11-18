package co.edu.ucentral.cursos.pruebasPrimeraEntrega;


import co.edu.ucentral.cursos.models.Curso;
import co.edu.ucentral.cursos.models.Evaluacion;
import co.edu.ucentral.cursos.models.Pregunta;
import co.edu.ucentral.cursos.service.CursoService;
import co.edu.ucentral.cursos.service.EvaluacionService;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EvaluacionFachada {
    public static void CrearEvaluacion(String nombreEvaluacion, ArrayList<Pregunta>pregunta,int cursoId){
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setNombre(nombreEvaluacion);
        //evaluacion.setPreguntas(pregunta);
        
        evaluacion.setPreguntaList(pregunta);       
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CursosUP");//crear el objeto de la clase entytiManagerFactory
        EntityManager manager = emf.createEntityManager();//crear un manejadro de entity,
        
        CursoService cursoDAO = new CursoService(manager);
        Curso curso = cursoDAO.find(cursoId);
        
        
        evaluacion.setCurso(curso);
        //iniciar una transaccion
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        EvaluacionService evaluacionDAO = new EvaluacionService(manager);
        evaluacionDAO.create(evaluacion);
        //llamar el Dao de la pregunta 
        
        tx.commit();
        manager.close();
    }
    
    public static Evaluacion ObtenerEvaluacion(int idEvaluacion){
        //se trae la evaluacion
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CursosUP");//crear el objeto de la clase entytiManagerFactory
        EntityManager manager = emf.createEntityManager();//crear un manejadro de entity,
        
        EvaluacionService evaluacionDAO = new EvaluacionService(manager);
        Evaluacion evaluacion = evaluacionDAO.find(idEvaluacion);
        
        return evaluacion;
    }
    
    //public static void GuardarRespuestasEvaRealizada(int idEstudiante,int idEvaluacion, RespuestaEstudiante[] respuestaEstudiante ){}
}
