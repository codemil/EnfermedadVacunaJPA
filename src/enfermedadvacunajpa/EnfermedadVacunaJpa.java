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
        guardarRegistroDeVacunacion();
//        consultarRegitroVacunacion();
//        actualizarRegistroVacunacion();
//        eliminarRegistroVacunacion();
    }
    
    private static void guardarRegistroDeVacunacion() {
        //Inicialización daos
        PersonaDao personaDao = new PersonaDao();
        VacunaDao vacunaDao = new VacunaDao();
        DosisDao dosisDao = new DosisDao();
        DosisAplicadaDao dosisAplicadaDao = new DosisAplicadaDao();

        for (int i = 0; i < 2; i++) {
            //Definición de persona
            Persona persona = new Persona("123456789 " + i, "C", "pepe", "perez", new Date());
            //Definición de historial
            Historial historial = new Historial(new Date());
            //Relación de historial - persona
            historial.setPersona(persona);
            //Relacion de persona - historial
            persona.setHistorial(historial);
            //Guardado de persona
            personaDao.guardar(persona);
            //Definición de vacuna
            Vacuna vacuna = new Vacuna("nombre vacuna " + i, "descripcion vacuna1");
            //Definición de enfermedad
            Enfermedad enfermedad = new Enfermedad("Nombre Enfermedad + " + i, "Descripción Enfermedad");
            //Relación de vacuna enfermedad
            vacuna.getEnfermedades().add(enfermedad);
            //Guardado de vacuna
            vacunaDao.guardar(vacuna);
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
//            Vacuna vacuna = dosis.getVacuna();
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

        Enfermedad enfermedad = enfermedadDao.obtenerPorId(227);
        enfermedad.setDescripcion("descripción actualizada");
        enfermedad.setNombre("Nombre Enfermedad");
        enfermedadDao.actualizar(enfermedad);

        Vacuna vacuna = vacunaDao.obtenerPorId(125);
        vacuna.setDescripcion("descripción actualizada");
        vacunaDao.actualizar(vacuna);

        Dosis dosis = dosisDao.obtenerPorId(7);
        dosis.setUnidadTiempo("M");
        Vacuna vacuna1 = vacunaDao.obtenerPorId(126);
        dosis.setIdVacuna(vacuna1);
        dosisDao.actualizar(dosis);

        DosisAplicada dosisAplicada = dosisAplicadaDao.obtenerPorId(3);
        dosisAplicada.setFechaAplicacion(new Date());
        Historial historial = historialDao.obtenerPorId(202);
        dosisAplicada.setIdHistorial(historial);
        dosisAplicadaDao.actualizar(dosisAplicada);

        Historial historial1 = historialDao.obtenerPorId(206);
        historial1.setFechaCreacion(new Date(System.currentTimeMillis() + 240000000));
        historialDao.actualizar(historial1);

        Persona persona = personaDao.obtenerPorId(205);
        persona.setNombres("nombres actualizados");
        personaDao.actualizar(persona);
    }

    private static void eliminarRegistroVacunacion() {
        PersonaDao personaDao = new PersonaDao();
        VacunaDao vacunaDao = new VacunaDao();
        DosisDao dosisDao = new DosisDao();
        DosisAplicadaDao dosisAplicadaDao = new DosisAplicadaDao();

        dosisAplicadaDao.eliminar(4);
        dosisDao.eliminar(8);
        vacunaDao.eliminar(125);
        personaDao.eliminar(205);

    }
}
