package DAO;

import POJO.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EquiposDAO {

    Equipo eq = new Equipo();

    public String obtenerNombreEquipo(int id_equipo) {
        String nombre = null;
        String sql = "SELECT nombre_equipo FROM equipos WHERE id = '" + id_equipo + "'";
        try (Connection conexion = Conexion.getConnection();
                Statement declaracion = conexion.createStatement();
                ResultSet rs = declaracion.executeQuery(sql)) {
            while (rs.next()) {
                nombre = rs.getString("nombre_equipo");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return nombre;
    }

    public int obtenerGoles(int id_equipo, boolean c, int id_partido) {
        int goles = -1;
        String sql = null;
        if (c) {//C= true: Equipo local
            sql = "SELECT goles_l AS goles FROM partidos AS p, equipos AS e WHERE e.id = '" + id_equipo + "' AND p.id = '" + id_partido + "'";
        } else {
            sql = "SELECT goles_v AS goles FROM partidos AS p, equipos AS e WHERE e.id = '" + id_equipo + "' AND p.id = '" + id_partido + "'";
        }
        try (Connection conexion = Conexion.getConnection();
                Statement declaracion = conexion.createStatement();
                ResultSet rs = declaracion.executeQuery(sql)) {
            while (rs.next()) {
                goles = rs.getInt("goles");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return goles;
    }

    public void agregarEquipo(Equipo eq) {
        String sql = "INSERT INTO equipos (nombre_equipo, nombre_entrenador)"
                + " VALUES(?,?)";
        try (Connection conexion2 = Conexion.getConnection();
                PreparedStatement cons = conexion2.prepareStatement(sql);) {
            cons.setString(1, eq.getNombre_equipo());
            cons.setString(2, eq.getEntrenador());
            cons.execute();
            JOptionPane.showMessageDialog(null, "Se guardó Equipo");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void modificarEquipo(Equipo eq) {
        String sql = "UPDATE equipos SET nombre_equipo = '" + eq.getNombre_equipo()
                + "', nombre_entrenador = '" + eq.getEntrenador() + "' WHERE id = '" + eq.getId() + "'";
        try (Connection conexion2 = Conexion.getConnection();
                PreparedStatement cons = conexion2.prepareStatement(sql);) {
            cons.execute();
            JOptionPane.showMessageDialog(null, "Se modificó Equipo");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void traerEquipo(JTextField n, JTextField en, JLabel i, int id) {
        String sql = "SELECT * FROM equipos WHERE id = '" + id + "'";
        try (Connection conexion = Conexion.getConnection();
                Statement declaracion = conexion.createStatement();
                ResultSet rs = declaracion.executeQuery(sql)) {
            while (rs.next()) {
                n.setText(rs.getString("nombre_equipo"));
                System.out.println(id + rs.getString("nombre_equipo"));
                en.setText(rs.getString("nombre_entrenador"));
                i.setText(rs.getString("id"));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean buscarEquipo(String nombre) {
        boolean esta = false;
        String nombreC = null;
        String sql = "SELECT nombre_equipo FROM equipos WHERE nombre_equipo = '" + nombre + "'";
        try (Connection conexion = Conexion.getConnection();
                Statement declaracion = conexion.createStatement();
                ResultSet rs = declaracion.executeQuery(sql)) {
            while (rs.next()) {
                nombreC = rs.getString("nombre_equipo");
            }
            esta = Objects.equals(nombre, nombreC);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return esta;
    }

    public void eliminarEquipo(int id) {
        String sql = "DELETE FROM equipos WHERE id = '" + id + "'";
        try (Connection conexion2 = Conexion.getConnection();
                PreparedStatement cons = conexion2.prepareStatement(sql);) {
            cons.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó Equipo");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Equipo> listar() {
        ArrayList<Equipo> equi = new ArrayList<>();
        String sql = "SELECT * FROM equipos";
        String nombre;
        String entrenador;
        int id;

        equi.removeAll(equi);

        try (Connection conexion = Conexion.getConnection();
                Statement declaracion = conexion.createStatement();
                ResultSet rs = declaracion.executeQuery(sql)) {
            while (rs.next()) {
                nombre = rs.getString("nombre_equipo");
                entrenador = rs.getString("nombre_entrenador");
                id = rs.getInt("id");
                equi.add(new Equipo(id, nombre, entrenador));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return equi;
    }
}
