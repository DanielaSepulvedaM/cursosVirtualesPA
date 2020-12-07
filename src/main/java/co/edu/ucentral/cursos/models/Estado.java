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
    @NamedQuery(name = "Estado.findAll", query = "SELECT c FROM Estado c"),
    @NamedQuery(name = "Estado.findByCursoId", query = "SELECT c FROM Curso c WHERE c.cursoId = :cursoId"),
    @NamedQuery(name = "Curso.findByCursoPublicado", query = "SELECT c FROM Curso c WHERE c.cursoPublicado = :cursoPublicado"),
    @NamedQuery(name = "Curso.findByCursoSuspendido", query = "SELECT c FROM Curso c WHERE c.cursoSuspendido = :cursoSuspendido"),
    @NamedQuery(name = "Curso.findByDuracionCurso", query = "SELECT c FROM Curso c WHERE c.duracionCurso = :duracionCurso")})

public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Lob
    @Size(max = 2147483647)
    @Column(name = "estado")
    @Id
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
