package co.edu.ucentral.cursos.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "docentes")
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d"),
    @NamedQuery(name = "Docente.findByDocenteId", query = "SELECT d FROM Docente d WHERE d.docenteId = :docenteId")})
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DocenteId")
    private Integer docenteId;
    
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Correo")
    private String correo;
    
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Clave")
    private String clave;
    
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Nombre")
    private String nombre;
    
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Documento")
    private String documento;
    
    @OneToMany(mappedBy = "docente")
    private List<Curso> cursoList;

    public Docente() {
    }

    public Docente(Integer docenteId) {
        this.docenteId = docenteId;
    }

    public Integer getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Integer docenteId) {
        this.docenteId = docenteId;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docenteId != null ? docenteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.docenteId == null && other.docenteId != null) || (this.docenteId != null && !this.docenteId.equals(other.docenteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.cursos.models.Docente[ docenteId=" + docenteId + " ]";
    }
    
}
