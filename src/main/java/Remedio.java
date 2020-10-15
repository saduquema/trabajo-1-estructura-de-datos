public class Remedio {
    public int referencia;
    public String tipoOrigen;
    public String funcionalidad;
    public String presentacion;
    public int costo;
    public Remedio( int referencia,String tipoOrigen, String funcionalidad, String presentacion, int costo){
        this.referencia = referencia;
        this.tipoOrigen = tipoOrigen;
        this.funcionalidad = funcionalidad;
        this.presentacion = presentacion;
        this.costo = costo;
    }
    @Override
    public String toString() {
        return "Remedio{" +
                "referencia='" + referencia + '\'' +
                ", material=" + tipoOrigen +
                ", diametro='" + funcionalidad + '\'' +
                ", profundidad=" + presentacion +
                ", cantidad='" + costo + '\'' +
                '}';
    }
}
