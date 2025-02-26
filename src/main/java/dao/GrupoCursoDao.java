package dao;

import model.GrupoCurso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrupoCursoDao {
    private final Connection con;

    public GrupoCursoDao(Connection con) {
        this.con = con;
    }

    public void agregarRelacion(GrupoCurso grupoCurso) throws SQLException {
        String query = "INSERT INTO grupocursoHBE (grupo_id, curso_id) VALUES (?, ?)";
        try (PreparedStatement setDePropiedades = con.prepareStatement(query)) {
            setDePropiedades.setInt(1, grupoCurso.getIdGrupo());
            setDePropiedades.setInt(2, grupoCurso.getIdCurso());

            setDePropiedades.executeUpdate();
        }
    }

    public void modificarRelacion(GrupoCurso grupoCurso) throws SQLException {
        String query = "UPDATE grupocursoHBE SET grupo_id = ?, curso_id = ? WHERE id = ?";
        try (PreparedStatement setDePropiedades = con.prepareStatement(query)) {
            setDePropiedades.setInt(1, grupoCurso.getIdGrupo());
            setDePropiedades.setInt(2, grupoCurso.getIdCurso());
            setDePropiedades.setInt(3, grupoCurso.getId());

            setDePropiedades.executeUpdate();
        }
    }

    public void eliminarRelacion(int id) throws SQLException {
        String query = "DELETE FROM grupocursoHBE WHERE id = ?";
        try (PreparedStatement setDePropiedades = con.prepareStatement(query)) {
            setDePropiedades.setInt(1, id);

            setDePropiedades.executeUpdate();
        }
    }

    public List<GrupoCurso> obtenerRelaciones() throws SQLException {
        List<GrupoCurso> relaciones = new ArrayList<>();
        String query = "SELECT * FROM grupocursoHBE";

        try (PreparedStatement setDePropiedades = con.prepareStatement(query)) {
            ResultSet rs = setDePropiedades.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int idGrupo = rs.getInt("grupo_id");
                int idCurso = rs.getInt("curso_id");
                relaciones.add(new GrupoCurso(id, idGrupo, idCurso));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return relaciones;
    }
}
