package co.edu.ucentral.cursos.service;

import co.edu.ucentral.cursos.models.CursoInscrito;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.ICursoInscritoService;

public class CursoInscritoService extends DAO<CursoInscrito, Integer> implements ICursoInscritoService{

    public CursoInscritoService(EntityManager em) {
        super(em);
    }

   
    public CursoInscrito find(Integer id) {
        return em.find(CursoInscrito.class, id);
    }

    
}
