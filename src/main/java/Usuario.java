public class Usuario {

    public long documento;
    public String nombre;
    public String apellido;
    public String correo;
    public String contrasena;

    public Usuario(long documento, String nombre, String apellido, String correo, String contrasena) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return '\n'+ "Usuario{" +
                "documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena=" + contrasena +
                '}';
    }
}
