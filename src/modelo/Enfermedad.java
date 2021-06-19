/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Milton
 */
@Entity
@Table(name = "ENFERMEDAD")
public class Enfermedad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @JoinTable(name = "ENFERMEDAD_VACUNA", joinColumns = {
        @JoinColumn(name = "ID_ENFERMEDAD", referencedColumnName = "ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_VACUNA", referencedColumnName = "ID")})
    @ManyToMany
    private Set<Vacuna> vacunas;

    public Enfermedad() {
    }

    public Enfermedad(Integer id) {
        this.id = id;
    }

    public Enfermedad(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.vacunas = new HashSet<>();
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

    public Set<Vacuna> getVacunas() {
        return vacunas;
    }

    public void setVacunas(Set<Vacuna> vacunas) {
        this.vacunas = vacunas;
    }

    @Override
    public String toString() {
        return "Enfermedad{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
}
