import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        EscribirJSON.generarJSON();
        TreeMap<Integer, Usuario> usuariosCargadosTree = LectorJSON.leerUsuariosJsonTreeSet();
        ArrayList<Usuario> usuariosCargadosArray = LectorJSON.leerUsuariosJsonArrayList();
    }
}
