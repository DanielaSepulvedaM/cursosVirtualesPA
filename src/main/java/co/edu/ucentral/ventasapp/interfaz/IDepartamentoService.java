package co.edu.ucentral.ventasapp.interfaz;

import co.edu.ucentral.cursos.models.Departamento;
import co.edu.ucentral.cursos.models.Facultad;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IDepartamentoService {
    public List<Departamento> listarDepartamentosPorFacultad(int facultadSeleccionada);
    public Departamento ObtenerPorId(int id);
    
    
}
