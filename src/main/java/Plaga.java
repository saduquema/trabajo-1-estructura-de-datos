public class Plaga {
    public long Referencia;
    public String Organismo;
    public long Cantidad;
    public String Remedio;

    public Plaga(long Referencia, String Organismo, long Cantidad, String Remedio) {
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