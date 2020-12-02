package co.edu.ucentral.cursos.service;

import co.edu.ucentral.cursos.models.Curso;
import co.edu.ucentral.cursos.models.Estudiante;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.IEstudianteService;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class EstudianteService extends DAO<Estudiante, Integer> implements IEstudianteService{
    
    
    
    @PersistenceContext(unitName = "CursosUP")
    protected EntityManager manager;
    
    @Override
    public Estudiante find(Integer id) {
        //return null;// _em.find(Estudiante.class, id);
        return this.manager.find(Estudiante.class, id);
    }

    @Override
    public Estudiante ObtenerPorId(int id) {
        return find(id);
    }

    @Override
    public Estudiante ObtenerPorLogin(String correo) {
        try {
            return (Estudiante) manager.createNamedQuery("Estudiante.findByCorreo").setParameter("correo", correo).getSingleResult();
        }catch(NoResultException e) {
            return null;
        }
    }
}
