package co.edu.ucentral.cursos.service;


import co.edu.ucentral.cursos.models.Respuesta;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.IRespuestaService;

public class RespuestaService extends DAO<Respuesta, Integer> implements IRespuestaService{

    public RespuestaService(EntityManager em) {
        super();
    }

    @Override
    public Respuesta find(Integer id) {
        return _em.find(Respuesta.class, id);
    }    
}
