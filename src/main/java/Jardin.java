public class Jardin {

    public String nombreDueno;
    public long area;
    public String ambiente;
    public long temperaturaPromedio;
    public String iluminacion;

    public Jardin(String nombreDueno, long area, String ambiente, long temperaturaPromedio, String iluminacion) {
        this.nombreDueno = nombreDueno;
        this.area = area;
        this.ambiente = ambiente;
        this.temperaturaPromedio = temperaturaPromedio;
        this.iluminacion = iluminacion;
    }

    @Override
    public String toString() {
        return '\n'+ "Jardin{" +
                "nombreDueno='" + nombreDueno + '\'' +
                ", area m2=" + area +
                ", ambiente='" + ambiente + '\'' +
                ", temperaturaPromedio °C=" + temperaturaPromedio +
                ", iluminacion='" + iluminacion + '\'' +
                '}';
    }
}
