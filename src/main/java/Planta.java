public class Planta {
    public int Referencia;
    public String Genero;
    public int Diametro;
    public int ProfundidadRaices;
    public String RequerimientoIluminacion;
    public int Cantidad;
    public int Costo;
    public Planta(int Referencia,String Genero,int Diametro,int ProfundidadRaices,String RequerimientoIluminacion,int Cantidad,int Costo){
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
