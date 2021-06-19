/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Milton
 * @param <Entidad>
 * @param <PK>
 */
public interface GenericoDao<Entidad, PK extends Serializable> {
    
     void guardar(Entidad e);

     Entidad obtenerPorId(PK id);

     List<Entidad> obtenerLista();

     void actualizar(Entidad e);

     void eliminar(PK id);
     
}
