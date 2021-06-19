/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enfermedadvacunajpa;

import Dao.DosisAplicadaDao;
import Dao.DosisDao;
import Dao.EnfermedadDao;
import Dao.HistorialDao;
import Dao.PersonaDao;
import Dao.VacunaDao;
import java.util.Date;
import java.util.List;
import java.util.Set;
import modelo.Dosis;
import modelo.DosisAplicada;
import modelo.Enfermedad;
import modelo.Historial;
import modelo.Persona;
import modelo.Vacuna;

/**
 *
 * @author Milton
 */
public class EnfermedadVacunaJpa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creación de registro de vacunación
//        guardarRegistroDeVacunacion();
//        consultarRegitroVacunacion();
//        actualizarRegistroVacunacion();
        eliminarRegistrosVacunacion();
    }

    private static void guardarRegistroDeVacunacion() {
        //Inicialización daos
        PersonaDao personaDao = new PersonaDao();
        EnfermedadDao enfermedadDao = new EnfermedadDao();
        DosisDao dosisDao = new DosisDao();
        DosisAplicadaDao dosisAplicadaDao = new DosisAplicadaDao();

        for (int i = 0; i < 10; i++) {
            //Definición de persona
            Persona persona = new Persona("123456789 " + i, "C", "pepe" + i, "perez" + i, new Date());
            //Definición de historial
            Historial historial = new Historial(new Date());
            //Relación de historial - persona
            historial.setPersona(persona);
            //Relacion de persona - historial
            persona.setHistorial(historial);
            //Guardado de persona
            personaDao.guardar(persona);
            //Definición de vacuna
            Vacuna vacuna = new Vacuna("nombre vacuna " + i, "descripcion vacuna " + i);
            //Definición de enfermedad
            Enfermedad enfermedad = new Enfermedad("Nombre Enfermedad " + i, "Descripción Enfermedad " + i);
            //Relación de vacuna enfermedad
            enfermedad.getVacunas().add(vacuna);
//            vacuna.getEnfermedades().add(enfermedad);
            //Guardado de vacuna
            enfermedadDao.guardar(enfermedad);
            //Definición de dosis
            Dosis dosis = new Dosis(2, "H", vacuna);
            //Guardado de dosis
            dosisDao.guardar(dosis);
            //Definición de dosis aplicada
            DosisAplicada dosisAplicada = new DosisAplicada(new Date(), dosis, historial);
            //Guardado de dosis aplicada
            dosisAplicadaDao.guardar(dosisAplicada);
        }
    }

    private static void consultarRegitroVacunacion() {
        PersonaDao personaDao = new PersonaDao();
        VacunaDao vacunaDao = new VacunaDao();
        DosisDao dosisDao = new DosisDao();
        DosisAplicadaDao dosisAplicadaDao = new DosisAplicadaDao();
        EnfermedadDao enfermedadDao = new EnfermedadDao();

//        List<Enfermedad> enfermedades = enfermedadDao.obtenerLista();
//        for (Enfermedad enfermedad : enfermedades) {
//            System.out.println("======Enfermedad======");
//            System.out.println(enfermedad);
//            System.out.println("======================");
//            System.out.println("======Vacunas========");
//            Set<Vacuna> vacunas = enfermedad.getVacunas();
//            for (Vacuna vacuna : vacunas) {
//                System.out.println(vacuna);
//            }
//            System.out.println("======================");
//        }
//        List<Dosis> listaDosis = dosisDao.obtenerLista();
//        for (Dosis dosis : listaDosis) {
//            System.out.println("======Dosis===========");
//            System.out.println(dosis);
//            System.out.println("======Vacuna==========");
//            Vacuna vacuna = dosis.getIdVacuna();
//            System.out.println(vacuna);
//            System.out.println("======Enfermedad======");
//            Set<Enfermedad> enfermedades = vacuna.getEnfermedades();
//            for (Enfermedad enfermedad : enfermedades) {
//                System.out.println(enfermedad);
//            }
//            System.out.println("======================");
//        }
        List<DosisAplicada> dosisAplicadas = dosisAplicadaDao.obtenerLista();
        for (DosisAplicada dosisAplicada : dosisAplicadas) {
            System.out.println("======Dosis Aplicada===========");
            System.out.println(dosisAplicada);
            System.out.println("======Dosis===========");
            Dosis dosis = dosisAplicada.getIdDosis();
            System.out.println(dosis);
            System.out.println("======Historial===========");
            Historial historial = dosisAplicada.getIdHistorial();
            System.out.println(historial);
            System.out.println("======Persona===========");
            Persona persona = historial.getPersona();
            System.out.println(persona);
            System.out.println("======================");
        }
    }

    private static void actualizarRegistroVacunacion() {
        PersonaDao personaDao = new PersonaDao();
        VacunaDao vacunaDao = new VacunaDao();
        DosisDao dosisDao = new DosisDao();
        DosisAplicadaDao dosisAplicadaDao = new DosisAplicadaDao();
        EnfermedadDao enfermedadDao = new EnfermedadDao();
        HistorialDao historialDao = new HistorialDao();

//        List<Enfermedad> enfermedades = enfermedadDao.obtenerLista();
//        for (int i = 0; i < enfermedades.size(); i++) {
//            Enfermedad enfermedad = enfermedades.get(i);
//            enfermedad.setDescripcion("descripción actualizada " + i);
//            enfermedadDao.actualizar(enfermedad);
//        }
//        List<Vacuna> vacunas = vacunaDao.obtenerLista();
//        for (int i = 0; i < vacunas.size(); i++) {
//            Vacuna vacuna = vacunas.get(i);
//            vacuna.setDescripcion("descripción actualizada " + i);
//            vacunaDao.actualizar(vacuna);
//        }
//
//        List<Dosis> listaDosis = dosisDao.obtenerLista();
//        for (int i = 0; i < listaDosis.size(); i++) {
//            Dosis dosis = listaDosis.get(i);
//            dosis.setUnidadTiempo("M");
//            if (dosis.getId() % 2 == 0) {
//                Vacuna vacuna1 = vacunaDao.obtenerPorId(365);
//                dosis.setIdVacuna(vacuna1);
//            }
//            dosisDao.actualizar(dosis);
//        }
//
//        List<DosisAplicada> listaDosisAplicada = dosisAplicadaDao.obtenerLista();
//        for (int i = 0; i < listaDosisAplicada.size(); i++) {
//            DosisAplicada dosisAplicada = listaDosisAplicada.get(i);
//            dosisAplicada.setFechaAplicacion(new Date());
//            Historial historial = historialDao.obtenerPorId(472);
//            dosisAplicada.setIdHistorial(historial);
//            dosisAplicadaDao.actualizar(dosisAplicada);
//        }
//
//        List<Historial> historiales = historialDao.obtenerLista();
//        for (int i = 0; i < historiales.size(); i++) {
//            Historial historial = historiales.get(i);
//            historial.setFechaCreacion(new Date(System.currentTimeMillis() + 240000000));
//            historialDao.actualizar(historial);
//        }
//
        List<Persona> personas = personaDao.obtenerLista();
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            persona.setNombres("demo");
            personaDao.actualizar(persona);
        }
    }

    private static void eliminarRegistrosVacunacion() {
        PersonaDao personaDao = new PersonaDao();
        VacunaDao vacunaDao = new VacunaDao();
        DosisDao dosisDao = new DosisDao();
        DosisAplicadaDao dosisAplicadaDao = new DosisAplicadaDao();
        EnfermedadDao enfermedadDao = new EnfermedadDao();
        HistorialDao historialDao = new HistorialDao();

        List<DosisAplicada> listaDosisAplicadas = dosisAplicadaDao.obtenerLista();
        for (int i = 0; i < listaDosisAplicadas.size(); i++) {
            DosisAplicada dosisAplicada = listaDosisAplicadas.get(i);
            dosisAplicadaDao.eliminar(dosisAplicada.getId());
        }

        List<Dosis> listaDosis = dosisDao.obtenerLista();
        for (int i = 0; i < listaDosis.size(); i++) {
            Dosis dosis = listaDosis.get(i);
            dosisDao.eliminar(dosis.getId());
        }

        List<Enfermedad> enfermedades = enfermedadDao.obtenerLista();
        for (int i = 0; i < enfermedades.size(); i++) {
            Enfermedad enfermedad = enfermedades.get(i);
            enfermedadDao.eliminar(enfermedad.getId());
        }

        List<Vacuna> vacunas = vacunaDao.obtenerLista();
        for (int i = 0; i < vacunas.size(); i++) {
            Vacuna vacuna = vacunas.get(i);
            vacunaDao.eliminar(vacuna.getId());
        }

        List<Persona> personas = personaDao.obtenerLista();
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            personaDao.eliminar(persona.getId());
        }
    }
}
