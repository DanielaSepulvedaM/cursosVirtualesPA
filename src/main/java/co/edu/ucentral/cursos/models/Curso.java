package co.edu.ucentral.cursos.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cursos")
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByCursoId", query = "SELECT c FROM Curso c WHERE c.cursoId = :cursoId"),
    @NamedQuery(name = "Curso.findByCursoPublicado", query = "SELECT c FROM Curso c WHERE c.cursoPublicado = :cursoPublicado"),
    @NamedQuery(name = "Curso.findByCursoSuspendido", query = "SELECT c FROM Curso c WHERE c.cursoSuspendido = :cursoSuspendido"),
    @NamedQuery(name = "Curso.findByDuracionCurso", query = "SELECT c FROM Curso c WHERE c.duracionCurso = :duracionCurso")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CursoId")
    private Integer cursoId;
    
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Nombre")
    private String nombre;
    
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Descripcion")
    private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CursoPublicado")
    private boolean cursoPublicado;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CursoSuspendido")
    private boolean cursoSuspendido;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DuracionCurso")
    private int duracionCurso;
    
    @JoinColumn(name = "DepartamentoId", referencedColumnName = "DepartamentoId")
    @ManyToOne
    private Departamento departamento;
    
    @JoinColumn(name = "DocenteId", referencedColumnName = "DocenteId")
    @ManyToOne
    private Docente docente;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<Evaluacion> evaluacionList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<CursoInscrito> cursoInscritoList;

    public Curso() {
        this.cursoId = 0;
    }

    public Curso(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public Curso(Integer cursoId, boolean cursoPublicado, boolean cursoSuspendido, int duracionCurso) {
        this.cursoId = cursoId;
        this.cursoPublicado = cursoPublicado;
        this.cursoSuspendido = cursoSuspendido;
        this.duracionCurso = duracionCurso;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getCursoPublicado() {
        return cursoPublicado;
    }

    public void setCursoPublicado(boolean cursoPublicado) {
        this.cursoPublicado = cursoPublicado;
    }

    public boolean getCursoSuspendido() {
        return cursoSuspendido;
    }

    public void setCursoSuspendido(boolean cursoSuspendido) {
        this.cursoSuspendido = cursoSuspendido;
    }

    public int getDuracionCurso() {
        return duracionCurso;
    }

    public void setDuracionCurso(int duracionCurso) {
        this.duracionCurso = duracionCurso;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public List<Evaluacion> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList) {
        this.evaluacionList = evaluacionList;
    }

    public List<CursoInscrito> getCursoInscritoList() {
        return cursoInscritoList;
    }

    public void setCursoInscritoList(List<CursoInscrito> cursoInscritoList) {
        this.cursoInscritoList = cursoInscritoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursoId != null ? cursoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.cursoId == null && other.cursoId != null) || (this.cursoId != null && !this.cursoId.equals(other.cursoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.cursos.models.Curso[ cursoId=" + cursoId + " ]";
    }
    
}
