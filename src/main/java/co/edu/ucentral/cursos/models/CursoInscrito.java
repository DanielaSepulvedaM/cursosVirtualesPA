package co.edu.ucentral.cursos.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cursosinscritos")
@Cacheable(false)
@NamedQueries({
    @NamedQuery(name = "CursoInscrito.findAll", query = "SELECT c FROM CursoInscrito c"),
    @NamedQuery(name = "CursoInscrito.findByCursoInscritoId", query = "SELECT c FROM CursoInscrito c WHERE c.cursoInscritoId = :cursoInscritoId"),
    @NamedQuery(name = "CursoInscrito.findByFechaInscripcion", query = "SELECT c FROM CursoInscrito c WHERE c.fechaInscripcion = :fechaInscripcion"),
    @NamedQuery(name = "CursoInscrito.findByCursoInscritoCalificado", query = "SELECT c FROM CursoInscrito c WHERE c.cursoInscritoCalificado = :cursoInscritoCalificado"),
    @NamedQuery(name = "CursoInscrito.findByEstudianteId", query = "SELECT c FROM CursoInscrito c WHERE c.estudiante.estudianteId = :idEstudiante")
})

public class CursoInscrito implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CursoInscritoId")
    private Integer cursoInscritoId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaInscripcion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInscripcion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CursoInscritoCalificado")
    private boolean cursoInscritoCalificado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursoInscrito",fetch = FetchType.EAGER)
    private List<EvaluacionRealizada> evaluacionRealizadaList;
    
    @JoinColumn(name = "CursoId", referencedColumnName = "CursoId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Curso curso;
    
    @JoinColumn(name = "EstudianteId", referencedColumnName = "EstudianteId")
    @ManyToOne(optional = false)
    private Estudiante estudiante;
    
    @Transient
    private double Nota;

    public double getNota() {
        return Nota;
    }

    public void setNota(double Nota) {
        this.Nota = Nota;
    }

    public CursoInscrito() {
    }

    public CursoInscrito(Integer cursoInscritoId) {
        this.cursoInscritoId = cursoInscritoId;
    }

    public CursoInscrito(Integer cursoInscritoId, Date fechaInscripcion, boolean cursoInscritoCalificado) {
        this.cursoInscritoId = cursoInscritoId;
        this.fechaInscripcion = fechaInscripcion;
        this.cursoInscritoCalificado = cursoInscritoCalificado;
    }

    public Integer getCursoInscritoId() {
        return cursoInscritoId;
    }

    public void setCursoInscritoId(Integer cursoInscritoId) {
        this.cursoInscritoId = cursoInscritoId;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public boolean getCursoInscritoCalificado() {
        return cursoInscritoCalificado;
    }

    public void setCursoInscritoCalificado(boolean cursoInscritoCalificado) {
        this.cursoInscritoCalificado = cursoInscritoCalificado;
    }

    public List<EvaluacionRealizada> getEvaluacionRealizadaList() {
        return evaluacionRealizadaList;
    }

    public void setEvaluacionRealizadaList(List<EvaluacionRealizada> evaluacionRealizadaList) {
        this.evaluacionRealizadaList = evaluacionRealizadaList;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursoInscritoId != null ? cursoInscritoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoInscrito)) {
            return false;
        }
        CursoInscrito other = (CursoInscrito) object;
        if ((this.cursoInscritoId == null && other.cursoInscritoId != null) || (this.cursoInscritoId != null && !this.cursoInscritoId.equals(other.cursoInscritoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.cursos.models.CursoInscrito[ cursoInscritoId=" + cursoInscritoId + " ]";
    }
    
}
