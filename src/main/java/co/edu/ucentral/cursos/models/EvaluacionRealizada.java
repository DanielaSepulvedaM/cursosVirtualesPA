package co.edu.ucentral.cursos.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "evaluacionsrealizadas")
@NamedQueries({
    @NamedQuery(name = "EvaluacionRealizada.findAll", query = "SELECT e FROM EvaluacionRealizada e"),
    @NamedQuery(name = "EvaluacionRealizada.findByEvaluacionRealizadaId", query = "SELECT e FROM EvaluacionRealizada e WHERE e.evaluacionRealizadaId = :evaluacionRealizadaId"),
    @NamedQuery(name = "EvaluacionRealizada.findByNota", query = "SELECT e FROM EvaluacionRealizada e WHERE e.nota = :nota")})
public class EvaluacionRealizada implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EvaluacionRealizadaId")
    private Integer evaluacionRealizadaId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nota")
    private double nota;
    
    @JoinColumn(name = "CursoInscritoId", referencedColumnName = "CursoInscritoId")
    @ManyToOne(optional = false)
    private CursoInscrito cursoInscrito;
    
    @JoinColumn(name = "EvaluacionId", referencedColumnName = "EvaluacionId")
    @ManyToOne(optional = false)
    private Evaluacion evaluacion;

    public EvaluacionRealizada() {
    }

    public EvaluacionRealizada(Integer evaluacionRealizadaId) {
        this.evaluacionRealizadaId = evaluacionRealizadaId;
    }

    public EvaluacionRealizada(Integer evaluacionRealizadaId, double nota) {
        this.evaluacionRealizadaId = evaluacionRealizadaId;
        this.nota = nota;
    }

    public Integer getEvaluacionRealizadaId() {
        return evaluacionRealizadaId;
    }

    public void setEvaluacionRealizadaId(Integer evaluacionRealizadaId) {
        this.evaluacionRealizadaId = evaluacionRealizadaId;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public CursoInscrito getCursoInscrito() {
        return cursoInscrito;
    }

    public void setCursoInscrito(CursoInscrito cursoInscrito) {
        this.cursoInscrito = cursoInscrito;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluacionRealizadaId != null ? evaluacionRealizadaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionRealizada)) {
            return false;
        }
        EvaluacionRealizada other = (EvaluacionRealizada) object;
        if ((this.evaluacionRealizadaId == null && other.evaluacionRealizadaId != null) || (this.evaluacionRealizadaId != null && !this.evaluacionRealizadaId.equals(other.evaluacionRealizadaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.cursos.models.EvaluacionRealizada[ evaluacionRealizadaId=" + evaluacionRealizadaId + " ]";
    }
    
}
