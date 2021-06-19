/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Milton
 */
@Entity
@Table(name = "FAMILIAR")
public class Familiar implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    @JoinColumn(name = "ID_HIJO")
    @ManyToOne(optional = false)
    private Persona idHijo;
    
    @JoinColumn(name = "ID_PADRE")
    @ManyToOne(optional = false)
    private Persona idPadre;

    public Familiar() {
    }

    public Familiar(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getIdHijo() {
        return idHijo;
    }

    public void setIdHijo(Persona idHijo) {
        this.idHijo = idHijo;
    }

    public Persona getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Persona idPadre) {
        this.idPadre = idPadre;
    }
    
    @Override
    public String toString() {
        return "Familiar{" + "id=" + id + ", padre=" + idPadre + ", hijo=" + idHijo + '}';
    }
}
