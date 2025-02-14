package controller;

import dao.EstudianteDao;
import model.DatabaseConection;
import model.Estudiante;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EstudianteController {
    public EstudianteDao estudianteDao;

    public EstudianteController() {
        Connection conn = DatabaseConection.getConnection();

        if (conn != null) {
            estudianteDao = new EstudianteDao(conn);
        } else {
            System.err.println("No se conectó");
        }
    }

    public void agregarEstudiante(String nombre, String identificacion, String email, String fecha_nacimiento, boolean estado) {
        if (estudianteDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }

        try {
            Estudiante estudianteParametros = new Estudiante(0, nombre, identificacion, email, fecha_nacimiento, estado);
            estudianteDao.agregarEstudiante(estudianteParametros);
            System.out.println("Estudiante agregado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarEstudiante (int id, String nombre, String identificacion, String email, String fecha_nacimiento, boolean estado) {
        if (estudianteDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }

        try {
            Estudiante estudianteParametros = new Estudiante(id, nombre, identificacion, email, fecha_nacimiento, estado);
            estudianteDao.modificarEstudiante(estudianteParametros);
            System.out.println("Estudiante modificado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarEstudiante (int id) {
        if (estudianteDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            List<Estudiante> allEstudiantes = estudianteDao.obtenerEstudiantes();
            for (Estudiante item : allEstudiantes) {
                if (id == item.getId()) {
                    estudianteDao.eliminarEstudiante(item);
                } else {
                    System.err.println("Estudiante no encontrado");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void obtenerEstudiantes() {
        if (estudianteDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }

        try {
            List<Estudiante> estudianteLista = estudianteDao.obtenerEstudiantes();

            for (Estudiante item : estudianteLista) {
                System.out.println("ID: " + item.getId() + ", Nombre: " + item.getNombre() + ", Identificacion: " + item.getIdentificacion() + ", Email: " + item.getEmail() + ", Fecha de Nacimiento: " + item.getFecha_nacimiento() + ", Estado: " + (item.isEstado() ? "Activo" : "Inactivo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
