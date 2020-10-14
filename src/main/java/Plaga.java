public class Plaga {
    public int Referencia;
    public String Organismo;
    public int Cantidad;
    public String Remedio;

    public Plaga(int Referencia, String Organismo, int Cantidad, String Remedio) {
        this.Referencia = Referencia;
        this.Organismo = Organismo;
        this.Cantidad = Cantidad;
        this.Remedio = Remedio;
    }

    @Override
    public String toString() {
        return "Plaga{" +
                "Referencia='" + Referencia + '\'' +
                ", Organismo=" + Organismo + '\'' +
                ", Cantidad='" + Cantidad + '\'' +
                ", Remedio=" + Remedio + '\'' +
                '}';
    }
}