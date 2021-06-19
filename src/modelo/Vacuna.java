/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Milton
 */
@Entity
@Table(name = "VACUNA")
public class Vacuna implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @ManyToMany(mappedBy = "vacunas")
    private Set<Enfermedad> enfermedades;

    public Vacuna() {
    }

    public Vacuna(Integer id) {
        this.id = id;
    }

    public Vacuna(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        enfermedades = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<Enfermedad> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(Set<Enfermedad> enfermedades) {
        this.enfermedades = enfermedades;
    }

    @Override
    public String toString() {
        return "Vacuna{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
}
