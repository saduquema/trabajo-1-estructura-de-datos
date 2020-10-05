public class Jardin {

    public String nombreDueno;
    public int area;
    public String ambiente;
    public int temperaturaPromedio;
    public String iluminacion;

    public Jardin(String nombreDueno, int area, String ambiente, int temperaturaPromedio, String iluminacion) {
        this.nombreDueno = nombreDueno;
        this.area = area;
        this.ambiente = ambiente;
        this.temperaturaPromedio = temperaturaPromedio;
        this.iluminacion = iluminacion;
    }

    @Override
    public String toString() {
        return "Jardin{" +
                "nombreDueño='" + nombreDueno + '\'' +
                ", area=" + area +
                ", ambiente='" + ambiente + '\'' +
                ", temperaturaPromedio=" + temperaturaPromedio +
                ", iluminacion='" + iluminacion + '\'' +
                '}';
    }
}
