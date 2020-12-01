package co.edu.ucentral.ventasapp.interfaz;

import co.edu.ucentral.cursos.models.Estudiante;
import javax.ejb.Local;

@Local
public interface IEstudianteService {
    public Estudiante ObtenerPorId(int id);
}
