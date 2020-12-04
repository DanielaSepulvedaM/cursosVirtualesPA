/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.ventasapp.interfaz;

import co.edu.ucentral.cursos.models.EvaluacionRealizada;
import javax.ejb.Local;

/**
 *
 * @author georg
 */
@Local
public interface IEvaluacionRealizadaService {
    public EvaluacionRealizada insertar(EvaluacionRealizada evaluacion);
    public EvaluacionRealizada find(Integer id);
}
