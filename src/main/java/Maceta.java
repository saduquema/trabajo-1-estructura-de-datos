
public class Maceta {
    public long referencia;
    public String material;
    public long diametro;
    public long profundidad;
    public long cantidad;
    public long costoUnitario;
    public Maceta( long referencia,String material, long diametro, long profundiad, long cantidad, long costoUnitario){
        this.referencia = referencia;
        this.material = material;
        this.diametro = diametro;
        this.profundidad = profundiad;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;

    }
    @Override
    public String toString() {
        return "Maceta{" +
                "referencia='" + referencia + '\'' +
                ", material=" + material +
                ", diametro='" + diametro + '\'' +
                ", profundidad=" + profundidad +
                ", cantidad='" + cantidad + '\'' +
                ", costoUnitario=" + costoUnitario + '\'' +
                '}';
    }
}
