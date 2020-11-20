
package co.edu.ucentral.cursos.service;


import co.edu.ucentral.cursos.models.Departamento;
import co.edu.ucentral.cursos.models.Facultad;
import javax.persistence.EntityManager;
import co.edu.ucentral.ventasapp.interfaz.IDepartamentoService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceContext;

@Stateless
public class DepartamentoService extends DAO<Departamento, Integer> implements IDepartamentoService{
    
    @PersistenceContext(unitName="CursosUP")
    EntityManager manager;
    
    public DepartamentoService() {
        super();
        this._em = manager;
    }

    @Override
    public Departamento find(Integer id) {
        return _em.find(Departamento.class, id);
    }

    @Override
    public List<Departamento> listarDepartamentosPorFacultad(Facultad facultadSeleccionada) {
        return manager.createNamedQuery("Departamento.findByFacultadId")
                .setParameter("facultadid", facultadSeleccionada.getFacultadId())
                .getResultList();
    }
}
