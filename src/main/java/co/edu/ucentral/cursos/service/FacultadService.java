package co.edu.ucentral.cursos.service;


import co.edu.ucentral.cursos.models.Facultad;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.IFacultadService;

public class FacultadService extends DAO<Facultad, Integer> implements IFacultadService{

    public FacultadService(EntityManager em) {
        super(em);
    }

    @Override
    public Facultad find(Integer id) {
        return em.find(Facultad.class, id);
    }
    
}
