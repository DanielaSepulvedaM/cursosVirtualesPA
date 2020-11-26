package co.edu.ucentral.ventasapp.interfaz;

import co.edu.ucentral.cursos.models.Evaluacion;
import javax.ejb.Local;

@Local
public interface IEvaluacionService {

    public Evaluacion ObtenerPorId(int evaluacionId);
    
}
