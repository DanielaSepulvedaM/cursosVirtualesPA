package co.edu.ucentral.cursos.service;


import co.edu.ucentral.cursos.models.Evaluacion;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.IEvaluacionService;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

@Stateless
public class EvaluacionService extends DAO<Evaluacion, Integer> implements IEvaluacionService{

    
    @PersistenceContext(unitName = "CursosUP")
    protected EntityManager manager;

    @Override
    public Evaluacion find(Integer id) {
        return null;// _em.find(Evaluacion.class, id);
    }

    public Evaluacion ObtenerPorId(int id) {
        return this.manager.find(Evaluacion.class, id);
    }
    
}
