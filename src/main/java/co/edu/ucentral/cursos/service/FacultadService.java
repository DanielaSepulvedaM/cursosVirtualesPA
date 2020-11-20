package co.edu.ucentral.cursos.service;


import co.edu.ucentral.cursos.models.Facultad;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.IFacultadService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceContext;

@Stateless
public class FacultadService extends DAO<Facultad, Integer> implements IFacultadService{
    
   @PersistenceContext(unitName="CursosUP")
    EntityManager manager;
    
    public FacultadService() {
        super();
        this._em = manager;
    }

    @Override
    public Facultad find(Integer id) {
        return _em.find(Facultad.class, id);
    }

    @Override
    public List<Facultad> listarFacultades() {
        return manager.createNamedQuery("Facultad.findAll").getResultList();
    }    
}
