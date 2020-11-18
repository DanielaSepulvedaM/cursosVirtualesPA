package co.edu.ucentral.cursos.service;


import co.edu.ucentral.cursos.models.Curso;
import java.util.List;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.ICursoService;


public class CursoService extends DAO<Curso, Integer> implements ICursoService{

    public CursoService(EntityManager em) {
        super(em);
    }

    @Override
    public Curso find(Integer id) {
        return em.find(Curso.class, id);
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
