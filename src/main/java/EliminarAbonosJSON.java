import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EliminarAbonosJSON {

    public static Scanner input = new Scanner(System.in);
    public static String ruta = "src/main/resources/database/";
    public static JSONArray abonosEliminar = LeerAbonosJSON.leerAbonos();

    public static void EliminarAbonos() {

        System.out.println(abonosEliminar);

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("Seleccionar por referencia del abono:");
        System.out.println();

        System.out.println("Lista de referencias de los abonos:");
        for (Object abonosObjeto : abonosEliminar) {
            JSONObject abonoJSON = (JSONObject) abonosObjeto;
            long referencia = (long) abonoJSON.get("referencia");
            System.out.println(referencia);
        }

        //Solicitud de datos del abono a eliminar
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("Ingrese la referencia del abono a eliminar:");
        int referenciaEliminar = input.nextInt();


        System.out.println("Datos del abono a eliminar:");
        for (Object abonoObjeto : abonosEliminar) {
            JSONObject abonoJSON = (JSONObject) abonoObjeto;
            long referencia = (long) abonoJSON.get("referencia");
            String tipoOrigen = ((String) abonoJSON.get("tipoOrigen"));
            String funcionalidad = ((String) abonoJSON.get("funcionalidad"));
            String presentacion = ((String) abonoJSON.get("presentacion"));
            long costo = (long) abonoJSON.get("costo");

            if (referenciaEliminar == (referencia)) {
                System.out.println("referencia: " + referencia);
                System.out.println("tipoOrigen: " + tipoOrigen);
                System.out.println("funcionalidad: " + funcionalidad);
                System.out.println("presentacion: " + presentacion);
                System.out.println("costo: " + costo);

            }
        }

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("¿Está seguro que desea eliminar el abono? Y:sí N:no");
        String in = input.next();
        if (in.equals("Y")) {
            EliminarAbonoArchivo(referenciaEliminar);
        } else if (in.equals("N")) {
            return;
        }
    }

    public static void   EliminarAbonoArchivo(int referenciaEliminar) {

        JSONArray abonosList = abonosEliminar;

//      Removiendo por referencia en la lista de abonos
        for (int i = 0; i < abonosList.size(); i++) {
            JSONObject abonoJSON = (JSONObject) abonosList.get(i);
            long referenciai = (long) abonoJSON.get("referencia");
            if (referenciaEliminar == (referenciai)) {
                abonosList.remove(i);
//                return;
            }
        }

        //Write JSON file
//        try (FileWriter file = new FileWriter(ruta + "usuarios.json", true)) {
        try (FileWriter file = new FileWriter(ruta + "abonos.json")) {

            file.write(abonosList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
