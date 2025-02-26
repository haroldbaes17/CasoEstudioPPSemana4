package dao;

import model.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDao {
    private final Connection con;

    public EstudianteDao(Connection con) {
        this.con = con;
    }

    public void agregarEstudiante(Estudiante estudiante) throws SQLException {
        String query = "INSERT INTO estudianteHBE (nombre, identificacion, email, fecha_nacimiento, estado) VALUES (?, ?, ?, ?, ?)";
//        "INSERT INTO usuarios (nombre, contrasenna, rol) VALUES (?, ?, ?)";?
        try (PreparedStatement setDePropiedades = con.prepareStatement(query)) {
            setDePropiedades.setString(1, estudiante.getNombre());
            setDePropiedades.setString(2, estudiante.getIdentificacion());
            setDePropiedades.setString(3, estudiante.getEmail());
            setDePropiedades.setString(4, estudiante.getFecha_nacimiento());
            setDePropiedades.setBoolean(5, estudiante.isEstado());

            setDePropiedades.executeUpdate();
        }
    }

    public void modificarEstudiante(Estudiante estudiante) throws SQLException {
        String query = "UPDATE estudianteHBE SET nombre = ?, identificacion = ?, email = ?, fecha_nacimiento = ?, estado = ? WHERE id = ?";
        try (PreparedStatement setDePropiedades = con.prepareStatement(query)) {
            setDePropiedades.setString(1, estudiante.getNombre());
            setDePropiedades.setString(2, estudiante.getIdentificacion());
            setDePropiedades.setString(3, estudiante.getEmail());
            setDePropiedades.setString(4, estudiante.getFecha_nacimiento());
            setDePropiedades.setBoolean(5, estudiante.isEstado());
            setDePropiedades.setInt(6, estudiante.getId());

            setDePropiedades.executeUpdate();
        }
    }

    public void eliminarEstudiante(Estudiante estudiante) throws SQLException {
        String query = "DELETE FROM estudianteHBE WHERE id = ?";
        try (PreparedStatement setDePropiedades = con.prepareStatement(query)) {
            setDePropiedades.setInt(1, estudiante.getId());

            setDePropiedades.executeUpdate();
        }
    }

    public List<Estudiante> obtenerEstudiantes() throws SQLException{
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        String query = "SELECT * FROM estudianteHBE";

        try (
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        ) {
            while (rs.next()) {
                listaEstudiantes.add(
                        new Estudiante(
                                rs.getInt("id"),
                                rs.getString("nombre"),
                                rs.getString("identificacion"),
                                rs.getString("email"),
                                rs.getString("fecha_nacimiento"),
                                rs.getBoolean("estado")
                        )
                );
            }
        }
        return listaEstudiantes;
    }
}
