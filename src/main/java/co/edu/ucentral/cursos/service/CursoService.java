package co.edu.ucentral.cursos.service;


import co.edu.ucentral.cursos.models.Curso;
import java.util.List;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.ICursoService;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

@Stateless
public class CursoService extends DAO<Curso, Integer> implements ICursoService{

   @PersistenceContext(unitName="CursosUP")
    EntityManager manager;
    
    public CursoService() {
        super();
        this._em = manager;    
    }

    @Override
    public Curso find(Integer id) {
        return manager.find(Curso.class, id);
    }

    @Override
    public List<Curso> listarCursos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso encontrarCursoPorId(int cursoId) {
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
