package DAO;

import POJO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class UsuariosDAO {

    public void registrar(Usuario us) {
        String sql = "INSERT INTO usuarios (cedula, clave, tipo)"
                + " VALUES(?,?,?)";
        try (Connection conexion2 = Conexion.getConnection();
                PreparedStatement cons = conexion2.prepareStatement(sql);) {
            cons.setInt(1, us.getCedula());
            cons.setInt(2, us.getClave());
            cons.setInt(3, us.getTipo());
            cons.execute();
            JOptionPane.showMessageDialog(null, "Usuario registrado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public int iniciarSesion(Usuario us) {
        int tipo = 0;
        String sql = "SELECT tipo FROM usuarios WHERE cedula = '" + us.getCedula() + "' AND clave = '" + us.getClave() + "'";
        try (Connection conexion = Conexion.getConnection();
                Statement declaracion = conexion.createStatement();
                ResultSet rs = declaracion.executeQuery(sql)) {
            while (rs.next()) {
                tipo = rs.getInt("tipo");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return tipo;
    }
}
