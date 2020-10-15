
public class Maceta {
    public int referencia;
    public String material;
    public int diametro;
    public int profundidad;
    public int cantidad;
    public int costoUnitario;
    public Maceta( int referencia,String material, int diametro, int profundiad, int cantidad, int costoUnitario){
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
