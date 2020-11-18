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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "estudiantes")
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByEstudianteId", query = "SELECT e FROM Estudiante e WHERE e.estudianteId = :estudianteId")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EstudianteId")
    private Integer estudianteId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private List<CursoInscrito> cursoInscritoList;

    public Estudiante() {
    }

    public Estudiante(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Integer getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
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

    public List<CursoInscrito> getCursoInscritoList() {
        return cursoInscritoList;
    }

    public void setCursoInscritoList(List<CursoInscrito> cursoInscritoList) {
        this.cursoInscritoList = cursoInscritoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudianteId != null ? estudianteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.estudianteId == null && other.estudianteId != null) || (this.estudianteId != null && !this.estudianteId.equals(other.estudianteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.cursos.models.Estudiante[ estudianteId=" + estudianteId + " ]";
    }
    
}
