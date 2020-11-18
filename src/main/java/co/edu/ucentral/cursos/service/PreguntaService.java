package co.edu.ucentral.cursos.service;


import co.edu.ucentral.cursos.models.Pregunta;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.IPreguntaService;

public class PreguntaService extends DAO<Pregunta, Integer> implements IPreguntaService{

    public PreguntaService(EntityManager em) {
        super(em);
    }

    @Override
    public Pregunta find(Integer id) {
        return em.find(Pregunta.class, id);
    }


    
}
