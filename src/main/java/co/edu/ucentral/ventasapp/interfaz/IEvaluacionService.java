package co.edu.ucentral.ventasapp.interfaz;

import co.edu.ucentral.cursos.models.Estudiante;
import co.edu.ucentral.cursos.models.Evaluacion;
import javax.ejb.Local;

@Local
public interface IEvaluacionService {

    public Evaluacion ObtenerPorId(int evaluacionId);

    public Evaluacion CrearEvaluacion(Evaluacion evaluacionActual);

    public Evaluacion ActualizarEvaluacion(Evaluacion evaluacionActual);
    
    public Evaluacion ObtenerEvaluacionCurso(int cursoId);
    
    public void  GuardarEvaluacion(Evaluacion evaluacion, Estudiante estudiante);
}
