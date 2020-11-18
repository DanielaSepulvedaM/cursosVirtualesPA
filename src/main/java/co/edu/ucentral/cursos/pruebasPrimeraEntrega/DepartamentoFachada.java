
package co.edu.ucentral.cursos.pruebasPrimeraEntrega;

import co.edu.ucentral.cursos.service.DepartamentoService;
import co.edu.ucentral.cursos.models.Departamento;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DepartamentoFachada {
    public static Departamento ObtenerDepartamento(int idDepartamento){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CursosUP");//crear el objeto de la clase entytiManagerFactory
        EntityManager manager = emf.createEntityManager();//crear un manejadro de entity,
        
        DepartamentoService departamentoDAO = new DepartamentoService(manager);
        Departamento departamento = departamentoDAO.find(idDepartamento);
        
        return departamento;    
    }
    
}
