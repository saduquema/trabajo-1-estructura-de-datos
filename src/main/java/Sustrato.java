public class Sustrato {
    public int Referencia;
    public int PorcentajeDeTierra;
    public int PorcentajeDeMinerales;
    public int PorcentajeDeAbono;
    public int Costo;
    public Sustrato( int Referencia, int PorcentajeDeTierra,int PorcentajeDeMinerales, int PorcentajeDeAbono, int Costo){
        this.Referencia= Referencia;
        this.PorcentajeDeTierra= PorcentajeDeTierra;
        this.PorcentajeDeMinerales= PorcentajeDeMinerales;
        this.PorcentajeDeAbono= PorcentajeDeAbono;
        this.Costo= Costo;
    }

    @Override
    public String toString() {
        return "Sustrato{" +
                "Referencia='" + Referencia + '\'' +
                ", Porcentaje de tierra=" + PorcentajeDeTierra + '\'' +
                ", Porcentaje de minerales='" + PorcentajeDeMinerales + '\'' +
                ", Porcentaje de abono=" + PorcentajeDeAbono +
                ", costoUnitario=" + Costo + '\'' +
                '}';
    }
}
