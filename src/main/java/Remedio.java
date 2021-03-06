public class Remedio {
    public long referencia;
    public String tipoOrigen;
    public String funcionalidad;
    public String presentacion;
    public long costo;
    public Remedio( long referencia,String tipoOrigen, String funcionalidad, String presentacion, long costo){
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
