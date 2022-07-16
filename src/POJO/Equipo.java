package POJO;

public class Equipo{

    int id;
    String nombre_equipo;
    String entrenador;

    public Equipo() {
    }

    public Equipo(int id, String nombre_equipo, String entrenador) {
        this.id = id;
        this.nombre_equipo = nombre_equipo;
        this.entrenador = entrenador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        return "Equipo{" + "id=" + id + ", nombre_equipo=" + nombre_equipo + ", entrenador=" + entrenador + '}';
    }
}
