public class Planta {
    public long Referencia;
    public String Genero;
    public long Diametro;
    public long ProfundidadRaices;
    public String RequerimientoIluminacion;
    public long Cantidad;
    public long Costo;
    public Planta(long Referencia,String Genero,long Diametro,long ProfundidadRaices,String RequerimientoIluminacion,long Cantidad,long Costo){
        this.Referencia=Referencia;
        this.Genero=Genero;
        this.Diametro=Diametro;
        this.ProfundidadRaices=ProfundidadRaices;
        this.RequerimientoIluminacion=RequerimientoIluminacion;
        this.Cantidad=Cantidad;
        this.Costo=Costo;
    }
    @Override
    public String toString(){
        return "Planta{" +
                "Referencia='" + Referencia + '\'' +
                ", Genero=" + Genero + '\'' +
                ", Diametro=" + Diametro + '\'' +
                ", Profundidad de raices=" + ProfundidadRaices + '\'' +
                ", Requerimiento de iluminacion=" + RequerimientoIluminacion + '\'' +
                ", Cantidad='" + Cantidad + '\'' +
                ", Costo=" + Costo + '\'' +
                '}';
    }
}
