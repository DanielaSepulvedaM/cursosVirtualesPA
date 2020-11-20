package co.edu.ucentral.ventasapp.interfaz;

import co.edu.ucentral.cursos.models.Facultad;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFacultadService {
    public List<Facultad> listarFacultades();
}
