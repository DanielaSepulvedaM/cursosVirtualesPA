package co.edu.ucentral.cursos.service;

import co.edu.ucentral.cursos.exceptions.NoPuedeInscribirException;
import co.edu.ucentral.cursos.models.Curso;
import co.edu.ucentral.cursos.models.CursoInscrito;
import co.edu.ucentral.cursos.models.Estudiante;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.ICursoInscritoService;
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
            return  (boolean) manager.createNamedQuery("CursoInscrito.findByEstudianteId").setParameter("idEstudiante",idEstudiante).getSingleResult();
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
            this.create(cursoIns, manager);
            //logica para incribir un curso
            //intancia del estudiante y del curso 
            
        }else{
           throw new NoPuedeInscribirException("No puede incribir mas cursos ya registra un curso inscrito");
        }
    }


    
}
