/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Milton
 * @param <Entidad>
 * @param <PK>
 */
public class GenericoDaoImpl<Entidad, PK extends Serializable> implements GenericoDao<Entidad, PK> {

    private final Session session;

    public GenericoDaoImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    private Class<Entidad> obtenerClase() {
        return (Class<Entidad>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void guardar(Entidad e) {
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
    }

    @Override
    public Entidad obtenerPorId(PK id) {
        Entidad e = session.find(obtenerClase(), id);
        return e;
    }

    @Override
    public List<Entidad> obtenerLista() {
        Class<Entidad> clase = obtenerClase();
        List<Entidad> entidades = session.createQuery("from " + clase.getName(), clase).getResultList();
        return entidades;
    }

    @Override
    public void actualizar(Entidad e) {
        session.beginTransaction();
        session.update(e);
        session.getTransaction().commit();
    }

    @Override
    public void eliminar(PK id) {
        Entidad e = session.find(obtenerClase(), id);
        session.beginTransaction();
        session.delete(e);
        session.getTransaction().commit();
    }
    
    public void cerrarSesion() {
        session.close();
    }
}
