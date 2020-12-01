package co.edu.ucentral.cursos.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "evaluacions")
@NamedQueries({
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e"),
    @NamedQuery(name = "Evaluacion.findByEvaluacionId", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionId = :evaluacionId"),
    @NamedQuery(name = "Evaluacion.findByCursoId", query = "SELECT e FROM Evaluacion e WHERE e.curso.cursoId = :cursoId ORDER BY e.evaluacionId DESC")
})
public class Evaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EvaluacionId")
    private Integer evaluacionId;
    
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Nombre")
    private String nombre;
    
    @JoinColumn(name = "CursoId", referencedColumnName = "CursoId")
    @ManyToOne(optional = false)
    private Curso curso;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluacion")
    private List<EvaluacionRealizada> evaluacionRealizadaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluacion", fetch = FetchType.EAGER)
    private List<Pregunta> preguntaList;

    public Evaluacion() {
    }

    public Evaluacion(Integer evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    public Integer getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(Integer evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<EvaluacionRealizada> getEvaluacionRealizadaList() {
        return evaluacionRealizadaList;
    }

    public void setEvaluacionRealizadaList(List<EvaluacionRealizada> evaluacionRealizadaList) {
        this.evaluacionRealizadaList = evaluacionRealizadaList;
    }

    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluacionId != null ? evaluacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.evaluacionId == null && other.evaluacionId != null) || (this.evaluacionId != null && !this.evaluacionId.equals(other.evaluacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.cursos.models.Evaluacion[ evaluacionId=" + evaluacionId + " ]";
    }
    
}
