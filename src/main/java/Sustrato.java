import java.util.Scanner;

public class Sustrato {
    public static String ruta = "src/main/resources/database/";
    public static Scanner input = new Scanner(System.in);
    public long Referencia;
    public long PorcentajeDeTierra;
    public long PorcentajeDeMinerales;
    public long PorcentajeDeAbono;
    public long Costo;

    public Sustrato(long Referencia, long PorcentajeDeTierra, long PorcentajeDeMinerales, long PorcentajeDeAbono, long Costo) {
        this.Referencia = Referencia;
        this.PorcentajeDeTierra = PorcentajeDeTierra;
        this.PorcentajeDeMinerales = PorcentajeDeMinerales;
        this.PorcentajeDeAbono = PorcentajeDeAbono;
        this.Costo = Costo;
    }

    @Override
    public String toString() {
        return "Sustrato{" +
                "Referencia='" + Referencia + '\'' +
                ", Porcentaje de tierra=" + PorcentajeDeTierra + '\'' +
                ", Porcentaje de minerales='" + PorcentajeDeMinerales + '\'' +
                ", Porcentaje de abono=" + PorcentajeDeAbono + '\'' +
                ", costo=" + Costo + '\'' +
                '}';
    }
}