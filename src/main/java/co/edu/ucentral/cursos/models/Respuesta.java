package co.edu.ucentral.cursos.models;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "respuestas")
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r"),
    @NamedQuery(name = "Respuesta.findByRespuestaId", query = "SELECT r FROM Respuesta r WHERE r.respuestaId = :respuestaId"),
    @NamedQuery(name = "Respuesta.findByRespuestaCorrecta", query = "SELECT r FROM Respuesta r WHERE r.respuestaCorrecta = :respuestaCorrecta")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RespuestaId")
    private Integer respuestaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RespuestaCorrecta")
    private boolean respuestaCorrecta;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "TextoRespuesta")
    private String textoRespuesta;
    @JoinColumn(name = "PreguntaId", referencedColumnName = "PreguntaId")
    @ManyToOne(optional = false)
    private Pregunta pregunta;

    public Respuesta() {
    }

    public Respuesta(Integer respuestaId) {
        this.respuestaId = respuestaId;
    }

    public Respuesta(Integer respuestaId, boolean respuestaCorrecta) {
        this.respuestaId = respuestaId;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Integer getRespuestaId() {
        return respuestaId;
    }

    public void setRespuestaId(Integer respuestaId) {
        this.respuestaId = respuestaId;
    }

    public boolean getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(boolean respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getTextoRespuesta() {
        return textoRespuesta;
    }

    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (respuestaId != null ? respuestaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.respuestaId == null && other.respuestaId != null) || (this.respuestaId != null && !this.respuestaId.equals(other.respuestaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.cursos.models.Respuesta[ respuestaId=" + respuestaId + " ]";
    }
    
}
