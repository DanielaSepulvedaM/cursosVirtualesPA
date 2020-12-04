/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.cursos.service;

import co.edu.ucentral.cursos.models.EvaluacionRealizada;
import co.edu.ucentral.ventasapp.interfaz.IEvaluacionRealizadaService;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author georg
 */
@Stateless
public class EvaluacionRealizadaService extends DAO<EvaluacionRealizada, Integer> implements IEvaluacionRealizadaService {

    @PersistenceContext(unitName = "CursosUP")
    protected EntityManager manager;
    
    @Override
    public EvaluacionRealizada find(Integer id) {
        return manager.find(EvaluacionRealizada.class, id);
    }

    @Override
    public EvaluacionRealizada insertar(EvaluacionRealizada evaluacion) {
        return this.create(evaluacion, manager);
    }
    
}
