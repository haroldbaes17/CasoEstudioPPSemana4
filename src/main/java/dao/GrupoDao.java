package dao;

import model.Grupo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrupoDao {
    private Connection con;

    public GrupoDao(Connection con) {
        this.con = con;
    }

    public void agregarGrupo(Grupo grupo) throws SQLException {
        String query = "INSERT INTO grupoHBE (nombre, descripcion, estado) VALUES (?, ?, ?)";

        try (PreparedStatement setDePropiedades = con.prepareStatement(query)) {
            setDePropiedades.setString(1, grupo.getNombre());
            setDePropiedades.setString(2, grupo.getDescripcion());
            setDePropiedades.setBoolean(3, grupo.isEstado());

            setDePropiedades.executeUpdate();
        }
    }

    public void modificarGrupo(Grupo grupo) throws SQLException {
        String query = "UPDATE grupoHBE SET nombre = ?, descripcion = ?, estado = ? WHERE id = ?";
        try (PreparedStatement setDePropiedades = con.prepareStatement(query)) {
            setDePropiedades.setString(1, grupo.getNombre());
            setDePropiedades.setString(2, grupo.getDescripcion());
            setDePropiedades.setBoolean(3, grupo.isEstado());
            setDePropiedades.setInt(4, grupo.getId());

            setDePropiedades.executeUpdate();
        }
    }

    public void eliminarGrupo(Grupo grupo) throws SQLException {
        String query = "DELETE FROM grupoHBE WHERE id = ?";
        try (PreparedStatement setDePropiedades = con.prepareStatement(query)) {
            setDePropiedades.setInt(1, grupo.getId());

            setDePropiedades.executeUpdate();
        }
    }

    public List<Grupo> obtenerGrupos() throws SQLException{
        List<Grupo> listaGrupos = new ArrayList<>();
        String query = "SELECT * FROM grupoHBE";

        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
        ) {
            while (rs.next()) {
                listaGrupos.add(
                        new Grupo(
                                rs.getInt("id"),
                                rs.getString("nombre"),
                                rs.getString("descripcion"),
                                rs.getBoolean("estado")
                        )
                );
            }
        }
        return listaGrupos;
    }
}
