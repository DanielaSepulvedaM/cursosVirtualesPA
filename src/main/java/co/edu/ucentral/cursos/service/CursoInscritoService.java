package co.edu.ucentral.cursos.service;

import co.edu.ucentral.cursos.exceptions.NoPuedeInscribirException;
import co.edu.ucentral.cursos.models.Curso;
import co.edu.ucentral.cursos.models.CursoInscrito;
import co.edu.ucentral.cursos.models.Estudiante;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.ICursoInscritoService;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class CursoInscritoService extends DAO<CursoInscrito, Integer> implements ICursoInscritoService{
    
    
    
    
    @PersistenceContext(unitName = "CursosUP")
    protected EntityManager manager;
    
   
    @Override
    public CursoInscrito find(Integer id) {
        return null;// _em.find(CursoInscrito.class, id);
    }

    
    private boolean puedeInscribirCurso(int idEstudiante) {
      try {
            manager.createNamedQuery("CursoInscrito.findByEstudianteId").setParameter("idEstudiante",idEstudiante).getSingleResult();
            return  false; 
        } catch (NoResultException e) {
            return true;
        }  
    }

    @Override
    public void IncribirCurso(Curso curso, Estudiante estudiante) throws NoPuedeInscribirException {
         boolean resultado = puedeInscribirCurso(estudiante.getEstudianteId());
        if(resultado){
            CursoInscrito cursoIns = new CursoInscrito();
            cursoIns.setCurso(curso);
            cursoIns.setEstudiante(estudiante);
            cursoIns.setCursoInscritoCalificado(false);
            cursoIns.setFechaInscripcion(new Date());
            this.create(cursoIns, manager);
        }else{
           throw new NoPuedeInscribirException("No puede incribir mas cursos ya registra un curso inscrito");
        }
    }


    
}
