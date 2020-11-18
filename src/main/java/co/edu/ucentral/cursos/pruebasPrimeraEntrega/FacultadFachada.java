package co.edu.ucentral.cursos.pruebasPrimeraEntrega;

import co.edu.ucentral.cursos.service.FacultadService;
import co.edu.ucentral.cursos.models.Facultad;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FacultadFachada {
    public static Facultad ObtenerFacultad(int idFacultad){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CursosUP");//crear el objeto de la clase entytiManagerFactory
        EntityManager manager = emf.createEntityManager();//crear un manejadro de entity,
        
        FacultadService facultadDAO = new FacultadService(manager);
        Facultad facultad = facultadDAO.find(idFacultad);
        
        return facultad;    
    }
}
