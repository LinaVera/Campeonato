package POJO;

import DAO.EquiposDAO;

public class Partido extends EquiposDAO{

    EquiposDAO eq = new EquiposDAO();

    int id_partido;
    String fecha;
    int id_equipo_l;
    int goles_l;
    int id_equipo_v;
    int goles_v;

    public Partido() {
    }

    public Partido(int id_partido, String fecha, int id_equipo_l, int goles_l, int id_equipo_v, int goles_v) {
        this.id_partido = id_partido;
        this.fecha = fecha;
        this.id_equipo_l = id_equipo_l;
        this.goles_l = goles_l;
        this.id_equipo_v = id_equipo_v;
        this.goles_v = goles_v;
    }

    public int getId_partido() {
        return id_partido;
    }

    public void setId(int id_partido) {
        this.id_partido = id_partido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_equipo_l() {
        return id_equipo_l;
    }

    public void setId_equipo_l(int id_equipo_l) {
        this.id_equipo_l = id_equipo_l;
    }

    public int getGoles_l() {
        return goles_l;
    }

    public void setGoles_l(int goles_l) {
        this.goles_l = goles_l;
    }

    public int getId_equipo_v() {
        return id_equipo_v;
    }

    public void setId_equipo_v(int id_equipo_v) {
        this.id_equipo_v = id_equipo_v;
    }

    public int getGoles_v() {
        return goles_v;
    }

    public void setGoles_v(int goles_v) {
        this.goles_v = goles_v;
    }

    @Override
    public String toString() {
        return fecha + " - "
                + eq.obtenerNombreEquipo(id_equipo_l)
                + "  (" + eq.obtenerGoles(id_equipo_l, true, id_partido) + ")  VS  "
                + "  (" + eq.obtenerGoles(id_equipo_v, false, id_partido) + ")  "
                + eq.obtenerNombreEquipo(id_equipo_v) + "\n";
    }

}
