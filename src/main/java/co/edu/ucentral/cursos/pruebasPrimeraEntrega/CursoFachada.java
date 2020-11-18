package co.edu.ucentral.cursos.pruebasPrimeraEntrega;

import co.edu.ucentral.cursos.models.Curso;
import co.edu.ucentral.cursos.service.CursoService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import co.edu.ucentral.ventasapp.interfaz.ICursoService;


@Stateless
public class CursoFachada implements ICursoService{
    
    @Inject
    private CursoService cursoDAO;
    
    
    public Curso encontrarCursoPorId(int cursoId){
        return cursoDAO.find(cursoId);
    }

    @Override
    public List<Curso> listarCursos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardarCurso(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarCurso(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarCurso(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
