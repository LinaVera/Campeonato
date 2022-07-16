package POJO;

public class Usuario {

    int cedula;
    int clave;
    int tipo;

    public Usuario() {
    }

    public Usuario(int cedula, int clave, int tipo) {
        this.cedula = cedula;
        this.clave = clave;
        this.tipo = tipo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", clave=" + clave + ", tipo=" + tipo + '}';
    }

}
