package co.edu.ucentral.ventasapp.interfaz;

import co.edu.ucentral.cursos.models.Docente;
import java.util.List;

public interface IDocenteService {
    public List<Docente> listarDocentes();
    public Docente ObtenerPorId(int id);
}
