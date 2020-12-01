package co.edu.ucentral.ventasapp.interfaz;

import co.edu.ucentral.cursos.models.Pregunta;
import javax.ejb.Local;

@Local
public interface IPreguntaService {
    public Pregunta CrearPregunta(Pregunta pregunta);
}
