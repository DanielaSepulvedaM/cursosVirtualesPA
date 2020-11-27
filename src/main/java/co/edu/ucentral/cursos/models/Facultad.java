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
@Table(name = "facultades")
@NamedQueries({
    @NamedQuery(name = "Facultad.findAll", query = "SELECT f FROM Facultad f"),
    @NamedQuery(name = "Facultad.findByFacultadId", query = "SELECT f FROM Facultad f WHERE f.facultadId = :facultadId")})
public class Facultad implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FacultadId")
    private Integer facultadId;
    
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Nombre")
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facultad")
    private List<Departamento> departamentoList;

    public Facultad() {
    }

    public Facultad(Integer facultadId) {
        this.facultadId = facultadId;
    }

    public Integer getFacultadId() {
        return facultadId;
    }

    public void setFacultadId(Integer facultadId) {
        this.facultadId = facultadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facultadId != null ? facultadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facultad)) {
            return false;
        }
        Facultad other = (Facultad) object;
        if ((this.facultadId == null && other.facultadId != null) || (this.facultadId != null && !this.facultadId.equals(other.facultadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.cursos.models.Facultad[ facultadId=" + facultadId + " ]";
    }
    
}
