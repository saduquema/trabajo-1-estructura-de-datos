public class UsuarioEjemplo {
    public int cedula;
    public String nombre;
    public int edad;
    public UsuarioEjemplo(int cedula, String nombre, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
