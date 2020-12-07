package co.edu.ucentral.cursos.service;

import co.edu.ucentral.cursos.models.Curso;
import java.util.List;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.ICursoService;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

@Stateless
public class CursoService extends DAO<Curso, Integer> implements ICursoService{

    @PersistenceContext(unitName = "CursosUP")
    protected EntityManager manager;
  
    //METODOS ABSTRACTO DE LA CLASE DAO SE HEREDO
    @Override
    public Curso find(Integer id) {
        return this.manager.find(Curso.class, id);
    }

    
    //METODOS ABSTRACTOS IMPLEMENTADOSDE LA INTERFAZ ICursoService
    @Override
    public List<Curso> listarCursos() {
        return manager.createNamedQuery("Curso.findAll")
                      .getResultList();
    }

    @Override
    public void guardarCurso(Curso curso) {
        this.create(curso, manager);
    }

    @Override
    public void modificarCurso(Curso curso) {
        this.update(curso, manager);
    }

    @Override
    public void eliminarCurso(Curso curso) {
        this.delete(curso, manager);
    } 

    @Override
    public Curso encontrarCursoPorId(int cursoid) {
        return this.manager.find(Curso.class, cursoid);
    }
}
