package co.edu.ucentral.ventasapp.interfaz;

import co.edu.ucentral.cursos.exceptions.NoPuedeInscribirException;
import co.edu.ucentral.cursos.models.Curso;
import co.edu.ucentral.cursos.models.Estudiante;
import javax.ejb.Local;

@Local
public interface ICursoInscritoService  {
    
    public void IncribirCurso(Curso curso,Estudiante estudiante) throws NoPuedeInscribirException;
    
}
