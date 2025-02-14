package controller;

import dao.GrupoDao;
import model.DatabaseConection;
import model.Grupo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GrupoController {
    private GrupoDao grupoDao;

    public GrupoController() {
        Connection conn = DatabaseConection.getConnection();

        if (conn != null) {
            grupoDao = new GrupoDao(conn);
        } else {
            System.err.println("No se conectó");
        }
    }

    public void agregarGrupo(String nombre, String descripcion, boolean estado) {
        if (grupoDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }

        try {
            Grupo grupoParametros = new Grupo(0, nombre, descripcion, estado);
            grupoDao.agregarGrupo(grupoParametros);
            System.out.println("Grupo agregado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarGrupo(int id, String nombre, String descripcion, boolean estado) {
        if (grupoDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            Grupo grupoParametros = new Grupo(id, nombre, descripcion, estado);
            grupoDao.modificarGrupo(grupoParametros);
            System.out.println("Grupo modificado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarGrupo(int id) {
        if (grupoDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }

        try {
            List<Grupo> allGrupos = grupoDao.obtenerGrupos();
            for (Grupo item : allGrupos) {
                if (item.getId() == id) {
                    grupoDao.eliminarGrupo(item);
                } else {
                    System.out.println("Grupo no encontrado");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void obtenerGrupos() {
        if (grupoDao == null) {
            System.err.println("Conexion no disponible");
            return;
        }

        try {
            List<Grupo> grupoLista = grupoDao.obtenerGrupos();

            for (Grupo item : grupoLista) {
                System.out.println("ID: " + item.getId() + ", Nombre: " + item.getNombre() + ", Descripcion: " + item.getDescripcion() + "Estado: " + (item.isEstado() ? "Activo" : "Inactivo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
