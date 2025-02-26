package controller;

import dao.GrupoCursoDao;
import model.DatabaseConection;
import model.GrupoCurso;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GrupoCursoController {
    private GrupoCursoDao grupoCursoDao;

    public GrupoCursoController() {
        Connection conn = DatabaseConection.getConnection();

        if (conn != null) {
            grupoCursoDao = new GrupoCursoDao(conn);
        } else {
            System.err.println("No se conectó");
        }
    }

    public void agregarRelacion (int idGrupo, int idCurso) {
        if (grupoCursoDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }

        try {
            GrupoCurso grupoCursoParametros = new GrupoCurso(0, idGrupo, idCurso);
            grupoCursoDao.agregarRelacion(grupoCursoParametros);
            System.out.println("Relacion agregada exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarRelacion (int id, int idGrupo, int idCurso) {
        if (grupoCursoDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }

        try {
            GrupoCurso grupoCursoParametros = new GrupoCurso(id, idGrupo, idCurso);
            grupoCursoDao.modificarRelacion(grupoCursoParametros);
            System.out.println("Relacion modificada exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarRelacion (int id) {
        if (grupoCursoDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }

        try {
            grupoCursoDao.eliminarRelacion(id);
            System.out.println("Relacion eliminada exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void obtenerRelaciones() {
        if (grupoCursoDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }

        try {
            List<GrupoCurso> relaciones = grupoCursoDao.obtenerRelaciones();

            for (GrupoCurso relacion : relaciones) {
                System.out.println("ID: " + relacion.getId() + ", Grupo con el ID: " + relacion.getIdGrupo() + " está relacionado al curso con ID: " + relacion.getIdCurso());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
