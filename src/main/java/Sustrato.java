public class Sustrato {
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
                ", PorcentajeDeTierra=" + PorcentajeDeTierra + '\'' +
                ", PorcentajeDeMinerales='" + PorcentajeDeMinerales + '\'' +
                ", PorcentajeDeAbono=" + PorcentajeDeAbono + '\'' +
                ", Costo=" + Costo + '\'' +
                '}';
    }
}