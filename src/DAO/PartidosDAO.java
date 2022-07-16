package DAO;

import POJO.Partido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class PartidosDAO {

    public void llenarCombo(JComboBox cb) {
        DefaultComboBoxModel value;
        String sql = "SELECT * FROM equipos";
        try (Connection conexion = Conexion.getConnection();
                Statement declaracion = conexion.createStatement();
                ResultSet rs = declaracion.executeQuery(sql)) {
            value = new DefaultComboBoxModel();
            while (rs.next()) {
                cb.addItem(rs.getString("nombre_equipo"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void agregarPartido(Partido p) {
        String sql = "INSERT INTO partidos (fecha, id_equipo_l, goles_l, id_equipo_v, goles_v)"
                + " VALUES(?,?,?,?,?)";
        try (Connection conexion2 = Conexion.getConnection();
                PreparedStatement cons = conexion2.prepareStatement(sql);) {
            cons.setString(1, p.getFecha());
            cons.setInt(2, p.getId_equipo_l());
            cons.setInt(3, p.getGoles_l());
            cons.setInt(4, p.getId_equipo_v());
            cons.setInt(5, p.getGoles_v());
            cons.execute();
            JOptionPane.showMessageDialog(null, "Se guardó partido");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public int idEquipo(String nom) {
        int id = 0;
        String sql = "SELECT * FROM equipos WHERE nombre_equipo = '" + nom + "'";
        try (Connection conexion = Conexion.getConnection();
                Statement declaracion = conexion.createStatement();
                ResultSet rs = declaracion.executeQuery(sql)) {
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return id;
    }

    public void listar(JTextArea ta) {

        Partido p = new Partido();
        String sql = "SELECT * FROM partidos ORDER BY fecha DESC";

        try (Connection conexion = Conexion.getConnection();
                Statement declaracion = conexion.createStatement();
                ResultSet rs = declaracion.executeQuery(sql)) {
            while (rs.next()) {
                p.setFecha(rs.getString("fecha"));
                p.setId_equipo_l(rs.getInt("id_equipo_l"));
                p.setGoles_l(rs.getInt("goles_l"));
                p.setId_equipo_v(rs.getInt("id_equipo_v"));
                p.setGoles_v(rs.getInt("goles_v"));
                p.setId(rs.getInt("id"));
                ta.append(p.toString());
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
