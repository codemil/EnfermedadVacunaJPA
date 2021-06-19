/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Milton
 */
@Entity
@Table(name = "DOSIS_APLICADA")
public class DosisAplicada implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FECHA_APLICACION")
    @Temporal(TemporalType.DATE)
    private Date fechaAplicacion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_DOSIS", referencedColumnName = "ID")
    private Dosis idDosis;

    @ManyToOne
    @JoinColumn(name = "ID_HISTORIAL", referencedColumnName = "ID_PERSONA")
    private Historial idHistorial;

    public DosisAplicada() {
    }

    public DosisAplicada(Integer id) {
        this.id = id;
    }

    public DosisAplicada(Date fechaAplicacion, Dosis dosis, Historial historial) {
        this.fechaAplicacion = fechaAplicacion;
        this.idDosis = dosis;
        this.idHistorial = historial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public Dosis getIdDosis() {
        return idDosis;
    }

    public void setIdDosis(Dosis idDosis) {
        this.idDosis = idDosis;
    }

    public Historial getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Historial idHistorial) {
        this.idHistorial = idHistorial;
    }

    @Override
    public String toString() {
        return "DosisAplicada{" + "id=" + id + ", fechaAplicacion=" + fechaAplicacion + '}';
    }
}
