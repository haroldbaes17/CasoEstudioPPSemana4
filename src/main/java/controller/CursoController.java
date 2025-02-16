package controller;

import dao.CursoDao;
import model.Curso;
import model.DatabaseConection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CursoController {
    private CursoDao cursoDao;

    public CursoController() {
        Connection conn = DatabaseConection.getConnection();

        if (conn != null) {
            cursoDao = new CursoDao(conn);
        } else {
            System.err.println("No se conectó");
        }
    }

    public void agregarCurso(String nombre, String descripcion, boolean estado) {
        if (cursoDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }

        try {
            Curso cursoParametros = new Curso(0, nombre, descripcion, estado);
            cursoDao.agregarCurso(cursoParametros);
            System.out.println("Curso agregado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarCurso(int id, String nombre, String descripcion, boolean estado) {
        if (cursoDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            Curso cursoParametros = new Curso(id, nombre, descripcion, estado);
            cursoDao.modificarCurso(cursoParametros);
            System.out.println("Curso modificado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCurso(int id) {
        if (cursoDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }

        try {
            List<Curso> allCursos = cursoDao.obtenerCursos();
            Curso cursoEncontrado = null;
            for (Curso item : allCursos) {
                if (item.getId() == id) cursoEncontrado = item;
            }

            if (cursoEncontrado != null) {
                cursoDao.eliminarCurso(cursoEncontrado);
                System.out.println("Curso eliminado correctamente");
            } else {
                System.out.println("Curso no encontrado");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void obtenerCursos() {
        if (cursoDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }

        try {
            List<Curso> cursoLista = cursoDao.obtenerCursos();

            for (Curso item : cursoLista) {
                System.out.println("ID: " + item.getId() + ", Nombre: " + item.getNombre() + ", Descripcion: " + item.getDescripcion() + ", Estado: " + (item.isEstado() ? "Activo" : "Inactivo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Curso> devolverCursos() throws SQLException {
        return cursoDao.obtenerCursos();
    }
}
