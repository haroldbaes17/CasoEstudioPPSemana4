package controller;

import dao.ProfesorDao;
import model.DatabaseConection;
import model.Profesor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProfesorController {
    public ProfesorDao profesorDao;

    public ProfesorController() {
        Connection conn = DatabaseConection.getConnection();

        if (conn != null) {
            profesorDao = new ProfesorDao(conn);
        } else {
            System.err.println("No se conectó");
        }
    }

    public void agregarProfesor(String nombre, String identificacion, String email, String departamento, boolean estado) {
        if (profesorDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }

        try {
            Profesor profesorParametros = new Profesor(0, nombre, identificacion, email, departamento, estado);
            profesorDao.agregarProfesor(profesorParametros);
            System.out.println("Profesor agregado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarProfesor (int id, String nombre, String identificacion, String email, String departamento, boolean estado) {
        if (profesorDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }

        try {
            Profesor profesorParametros = new Profesor(id, nombre, identificacion, email, departamento, estado);
            profesorDao.modificarProfesor(profesorParametros);
            System.out.println("Profesor modificado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProfesor (int id) {
        if (profesorDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            List<Profesor> allProfesores = profesorDao.obtenerProfesores();
            for (Profesor item : allProfesores) {
                if (id == item.getId()) {
                    profesorDao.eliminarProfesor(item);
                } else {
                    System.err.println("Profesor no encontrado");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void obtenerProfesores() {
        if (profesorDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }

        try {
            List<Profesor> profesorLista = profesorDao.obtenerProfesores();

            for (Profesor item : profesorLista) {
                System.out.println("ID: " + item.getId() + ", Nombre: " + item.getNombre() + ", Identificacion: " + item.getIdentificacion() + ", Email: " + item.getEmail() + ", Departamento: " + item.getDepartamento() + ", Estado: " + (item.isEstado() ? "Activo" : "Inactivo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
