package co.edu.ucentral.cursos.service;


import co.edu.ucentral.cursos.models.Evaluacion;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.IEvaluacionService;

public class EvaluacionService extends DAO<Evaluacion, Integer> implements IEvaluacionService{

    public EvaluacionService(EntityManager em) {
        super();
    }

    @Override
    public Evaluacion find(Integer id) {
        return null;// _em.find(Evaluacion.class, id);
    }
    
}
