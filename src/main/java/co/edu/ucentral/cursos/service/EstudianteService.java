package co.edu.ucentral.cursos.service;


import co.edu.ucentral.cursos.models.Estudiante;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.IEstudianteService;

public class EstudianteService extends DAO<Estudiante, Integer> implements IEstudianteService{

    public EstudianteService(EntityManager em) {
        super();
    }

    @Override
    public Estudiante find(Integer id) {
        return null;// _em.find(Estudiante.class, id);
    }

    
}
