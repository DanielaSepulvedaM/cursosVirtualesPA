package co.edu.ucentral.cursos.service;


import co.edu.ucentral.cursos.models.Pregunta;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.IPreguntaService;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

@Stateless
public class PreguntaService extends DAO<Pregunta, Integer> implements IPreguntaService{

    @PersistenceContext(unitName = "CursosUP")
    protected EntityManager manager;

    @Override
    public Pregunta find(Integer id) {
        return null;// _em.find(Pregunta.class, id);
    }

    @Override
    public Pregunta CrearPregunta(Pregunta pregunta){
        return this.create(pregunta, manager);
    }

    
}
