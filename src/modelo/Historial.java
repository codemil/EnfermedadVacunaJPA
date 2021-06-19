/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author Milton
 */
@Entity
@Table(name = "HISTORIAL")
public class Historial implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "foreignGeneratorPersona")
    @org.hibernate.annotations.GenericGenerator(
            name = "foreignGeneratorPersona",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "persona")
    )
    @Column(name = "ID_PERSONA")
    private Integer idPersona;

    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @OneToMany(mappedBy = "idHistorial")
    private Set<DosisAplicada> dosisAplicadas;

    @OneToOne(optional = false)
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID", insertable = false, updatable = false)
    private Persona persona;

    public Historial() {
    }

    public Historial(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Historial(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Set<DosisAplicada> getDosisAplicadas() {
        return dosisAplicadas;
    }

    public void setDosisAplicadas(Set<DosisAplicada> dosisAplicadas) {
        this.dosisAplicadas = dosisAplicadas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    @Override
    public String toString() {
        return "Historial{" + "idPersona=" + idPersona + ", fechaCreacion=" + fechaCreacion + '}';
    }
}
