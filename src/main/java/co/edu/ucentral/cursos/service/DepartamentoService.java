
package co.edu.ucentral.cursos.service;


import co.edu.ucentral.cursos.models.Departamento;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.IDepartamentoService;

public class DepartamentoService extends DAO<Departamento, Integer> implements IDepartamentoService{

    public DepartamentoService(EntityManager em) {
        super(em);
    }

    @Override
    public Departamento find(Integer id) {
        return em.find(Departamento.class, id);
    }
    
}
