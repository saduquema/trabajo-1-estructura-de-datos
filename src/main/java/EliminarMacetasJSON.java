
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EliminarMacetasJSON {

    public static Scanner input = new Scanner(System.in);
    public static String ruta = "src/main/resources/database/";
    public static JSONArray macetasEliminar = LeerMacetasJSON.leerMacetas();

    public static void EliminarMacetas() {

        System.out.println(macetasEliminar);

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("Seleccionar por referencia de la maceta:");
        System.out.println();

        System.out.println("Lista de referencias de las macetas:");
        for (Object macetasObjeto : macetasEliminar) {
            JSONObject macetaJSON = (JSONObject) macetasObjeto;
            long referencia = (long) macetaJSON.get("referencia");
            System.out.println(referencia);
        }

        //Solicitud de datos de la maceta a eliminar
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("Ingrese la referencia de la maceta a eliminar:");
        int referenciaEliminar = input.nextInt();


        System.out.println("Datos de la maceta a eliminar:");
        for (Object macetaObjeto : macetasEliminar) {
            JSONObject macetaJSON = (JSONObject) macetaObjeto;
            long referencia = (long) macetaJSON.get("referencia");
            String material = ((String) macetaJSON.get("material"));
            long diametro = (long) macetaJSON.get("diametro");
            long profundidad = ((long) macetaJSON.get("profundidad"));
            long cantidad = ((long) macetaJSON.get("cantidad"));
            long costoUnitario = ((long) macetaJSON.get("costoUnitario"));

            if (referenciaEliminar == (referencia)) {
                System.out.println("referencia: " + referencia);
                System.out.println("material: " + material);
                System.out.println("diametro: " + diametro);
                System.out.println("profundidad: " + profundidad);
                System.out.println("cantidad: " + cantidad);
                System.out.println("costoUnitario: " + costoUnitario);
            }
        }

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("¿Está seguro que desea eliminar la maceta? Y:sí N:no");
        String in = input.next();
        if (in.equals("Y")) {
            EliminarMacetaArchivo(referenciaEliminar);
        } else if (in.equals("N")) {
            return;
        }
    }

    public static void   EliminarMacetaArchivo(int referenciaEliminar) {

        JSONArray macetasList = macetasEliminar;

//      Removiendo por referencia en la lista de macetas
        for (int i = 0; i < macetasList.size(); i++) {
            JSONObject macetaJSON = (JSONObject) macetasList.get(i);
            long referenciai = (long) macetaJSON.get("referencia");
            if (referenciaEliminar == (referenciai)) {
                macetasList.remove(i);
//                return;
            }
        }

        //Write JSON file
//        try (FileWriter file = new FileWriter(ruta + "usuarios.json", true)) {
        try (FileWriter file = new FileWriter(ruta + "macetas.json")) {

            file.write(macetasList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}