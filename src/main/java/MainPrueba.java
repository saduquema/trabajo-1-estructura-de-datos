import java.util.ArrayList;
import java.util.TreeMap;

public class MainPrueba {
    public static void main(String[] args) {
        EscribirJSON.generarJSON();
        TreeMap<Integer, UsuarioEjemplo> usuariosCargadosTree = LectorJSON.leerUsuariosJsonTreeSet();
        ArrayList<UsuarioEjemplo> usuariosCargadosArray = LectorJSON.leerUsuariosJsonArrayList();
    }
}
