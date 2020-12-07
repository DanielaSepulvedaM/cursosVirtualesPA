package co.edu.ucentral.ventasapp.interfaz;

import co.edu.ucentral.cursos.models.Curso;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ICursoService {
    public List<Curso> listarCursos();
    public Curso encontrarCursoPorId(int cursoid);
    public void guardarCurso(Curso curso);
    public void modificarCurso(Curso curso);
    public void eliminarCurso(Curso curso);
    
    //public void CrearCurso(String nombre,String descripcion, Boolean publicada, int duracion);
    
}
