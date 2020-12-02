package co.edu.ucentral.cursos.service;

import co.edu.ucentral.cursos.models.Docente;
import co.edu.ucentral.ventasapp.interfaz.IDocenteService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class DocenteService extends DAO<Docente, Integer> implements IDocenteService{

    @PersistenceContext(unitName = "CursosUP")
    protected EntityManager manager;
    
    @Override
    public Docente find(Integer id) {
        return this.manager.find(Docente.class, id);
    }

    @Override
    public List<Docente> listarDocentes() {
        return manager.createNamedQuery("Docente.findAll").getResultList();
    }

    @Override
    public Docente ObtenerPorId(int id) {
        return find(id);
    }

    @Override
    public Docente ObtenerPorLogin(String correo) {
        try {
            return (Docente) manager.createNamedQuery("Docente.findByCorreo").setParameter("correo", correo).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
