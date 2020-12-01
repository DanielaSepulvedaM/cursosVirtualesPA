package co.edu.ucentral.cursos.service;


import co.edu.ucentral.cursos.models.Estudiante;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.IEstudianteService;
import javax.persistence.PersistenceContext;

public class EstudianteService extends DAO<Estudiante, Integer> implements IEstudianteService{
    
    @PersistenceContext(unitName = "CursosUP")
    protected EntityManager manager;
    
    public EstudianteService(EntityManager em) {
        super();
    }

    @Override
    public Estudiante find(Integer id) {
        return null;// _em.find(Estudiante.class, id);
    }

    @Override
    public Estudiante ObtenerPorId(int id) {
        return this.manager.find(Estudiante.class, id);
    }

    
}
