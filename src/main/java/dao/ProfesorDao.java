package dao;

import model.Profesor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDao {
    private Connection con;

    public ProfesorDao(Connection con) {
        this.con = con;
    }

    public void agregarProfesor(Profesor profesor) throws SQLException {
        String query = "INSERT INTO profesorHBE (nombre, identificacion, email, departamento, estado) VALUES (?,?,?,?,?)";

        try (PreparedStatement setDePropiedades = con.prepareStatement(query)) {
            setDePropiedades.setString(1, profesor.getNombre());
            setDePropiedades.setString(2, profesor.getIdentificacion());
            setDePropiedades.setString(3, profesor.getEmail());
            setDePropiedades.setString(4, profesor.getDepartamento());
            setDePropiedades.setBoolean(5, profesor.isEstado());

            setDePropiedades.executeUpdate();
        }
    }

    public void modificarProfesor(Profesor profesor) throws SQLException {
        String query = "UPDATE profesorHBE SET nombre = ?, identificacion = ?, email = ?, departamento = ?, estado = ? WHERE id = ?";
        try (PreparedStatement setDePropiedades = con.prepareStatement(query)) {
            setDePropiedades.setString(1, profesor.getNombre());
            setDePropiedades.setString(2, profesor.getIdentificacion());
            setDePropiedades.setString(3, profesor.getEmail());
            setDePropiedades.setString(4, profesor.getDepartamento());
            setDePropiedades.setBoolean(5, profesor.isEstado());
            setDePropiedades.setInt(6, profesor.getId());

            setDePropiedades.executeUpdate();
        }
    }

    public void eliminarProfesor(Profesor profesor) throws SQLException {
        String query = "DELETE FROM profesorHBE WHERE id = ?";
        try (PreparedStatement setDePropiedades = con.prepareStatement(query)) {
            setDePropiedades.setInt(1, profesor.getId());

            setDePropiedades.executeUpdate();
        }
    }

    public List<Profesor> obtenerProfesores() throws SQLException{
        List<Profesor> listaProfesores = new ArrayList<>();
        String query = "SELECT * FROM profesorHBE";

        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
        ) {
            while (rs.next()) {
                listaProfesores.add(
                        new Profesor(
                                rs.getInt("id"),
                                rs.getString("nombre"),
                                rs.getString("identificacion"),
                                rs.getString("email"),
                                rs.getString("departamento"),
                                rs.getBoolean("estado")
                        )
                );
            }
        }
        return listaProfesores;
    }
}
