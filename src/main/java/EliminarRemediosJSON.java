
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EliminarRemediosJSON {

    public static Scanner input = new Scanner(System.in);
    public static String ruta = "src/main/resources/database/";
    public static JSONArray remediosEliminar = LeerRemediosJSON.leerRemedios();

    public static void EliminarRemedios() {

        System.out.println(remediosEliminar);

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("Seleccionar por referencia del remedio:");
        System.out.println();

        System.out.println("Lista de referencias de los remedios:");
        for (Object remediosObjeto : remediosEliminar) {
            JSONObject remedioJSON = (JSONObject) remediosObjeto;
            long referencia = (long) remedioJSON.get("referencia");
            System.out.println(referencia);
        }

        //Solicitud de datos del remedio a eliminar
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("Ingrese la referencia del remedio a eliminar:");
        int referenciaEliminar = input.nextInt();


        System.out.println("Datos del remedio a eliminar:");
        for (Object remedioObjeto : remediosEliminar) {
            JSONObject remedioJSON = (JSONObject)remedioObjeto;
            long referencia = (long) remedioJSON.get("referencia");
            String tipoOrigen = ((String) remedioJSON.get("tipoOrigen"));
            String funcionalidad = ((String) remedioJSON.get("funcionalidad"));
            String presentacion = ((String) remedioJSON.get("presentacion"));
            long costo = (long) remedioJSON.get("costo");

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
        System.out.println("¿Está seguro que desea eliminar el remedio? Y:sí N:no");
        String in = input.next();
        if (in.equals("Y")) {
            EliminarRemedioArchivo(referenciaEliminar);
        } else if (in.equals("N")) {
            return;
        }
    }

    public static void   EliminarRemedioArchivo(int referenciaEliminar) {

        JSONArray remediosList = remediosEliminar;

//      Removiendo por referencia en la lista de remedios
        for (int i = 0; i < remediosList.size(); i++) {
            JSONObject remedioJSON = (JSONObject) remediosList.get(i);
            long referenciai = (long) remedioJSON.get("referencia");
            if (referenciaEliminar == (referenciai)) {
                remediosList.remove(i);
//                return;
            }
        }

        //Write JSON file
//        try (FileWriter file = new FileWriter(ruta + "usuarios.json", true)) {
        try (FileWriter file = new FileWriter(ruta + "remedios.json")) {

            file.write(remediosList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}