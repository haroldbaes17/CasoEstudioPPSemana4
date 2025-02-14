package dao;


import model.Curso;
import model.Grupo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDao {
    private Connection con;

    public CursoDao(Connection con) {
        this.con = con;
    }

    public void agregarCurso(Curso curso) throws SQLException {
        String query = "INSERT INTO curso (nombre, descripcion, estado) VALUES (?, ?, ?)";

        try (PreparedStatement setDePropiedades = con.prepareStatement(query)) {
            setDePropiedades.setString(1, curso.getNombre());
            setDePropiedades.setString(2, curso.getDescripcion());
            setDePropiedades.setBoolean(3, curso.isEstado());

            setDePropiedades.executeUpdate();
        }
    }

    public void modificarCurso(Curso curso) throws SQLException {
        String query = "UPDATE curso SET nombre = ?, descripcion = ?, estado = ? WHERE id = ?";
        try (PreparedStatement setDePropiedades = con.prepareStatement(query)) {
            setDePropiedades.setString(1, curso.getNombre());
            setDePropiedades.setString(2, curso.getDescripcion());
            setDePropiedades.setBoolean(3, curso.isEstado());
            setDePropiedades.setInt(4, curso.getId());

            setDePropiedades.executeUpdate();
        }
    }

    public void eliminarCurso(Curso curso) throws SQLException {
        String query = "DELETE FROM curso WHERE id = ?";
        try (PreparedStatement setDePropiedades = con.prepareStatement(query)) {
            setDePropiedades.setInt(1, curso.getId());

            setDePropiedades.executeUpdate();
        }
    }

    public List<Curso> obtenerCursos() throws SQLException{
        List<Curso> listaCursos = new ArrayList<>();
        String query = "SELECT * FROM curso";

        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
        ) {
            while (rs.next()) {
                listaCursos.add(
                        new Curso(
                                rs.getInt("id"),
                                rs.getString("nombre"),
                                rs.getString("descripcion"),
                                rs.getBoolean("estado")
                        )
                );
            }
        }
        return listaCursos;
    }
}
