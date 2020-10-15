import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EliminarJardinesJSON {

    public static Scanner input = new Scanner(System.in);
    public static String ruta = "src/main/resources/database/";
    public static JSONArray jardinesEliminar = LeerJardinesJSON.leerJardines();

    public static void EliminarJardines() {

        System.out.println(jardinesEliminar);

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("Seleccionar por nombre del dueño/jardín:");
        System.out.println();

        System.out.println("Lista de nombres dueño/jardín:");
        for (Object jardinObjeto : jardinesEliminar) {
            JSONObject jardinJSON = (JSONObject) jardinObjeto;
            String nombreDueno = (String) jardinJSON.get("nombreDueno");
            System.out.println(nombreDueno);
        }

        //Solicitud de datos del jardin a eliminar
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("Ingrese el nombre dueño/jardín a eliminar:");
        String nombreDuenoEliminar = input.next();


        System.out.println("Datos del jardín a eliminar:");
        for (Object jardinObjeto : jardinesEliminar) {
            JSONObject jardinJSON = (JSONObject) jardinObjeto;
            String nombreDueno = (String) jardinJSON.get("nombreDueno");
            long area = ((long) jardinJSON.get("area"));
            String ambiente = (String) jardinJSON.get("ambiente");
            long temperaturaPromedio = ((long) jardinJSON.get("temperaturaPromedio"));
            String iluminacion = ((String) jardinJSON.get("iluminacion"));

            if (nombreDuenoEliminar.equals(nombreDueno)) {
                System.out.println("nombreDueno: " + nombreDueno);
                System.out.println("area: " + area);
                System.out.println("ambiente: " + ambiente);
                System.out.println("temperaturaPromedio: " + temperaturaPromedio);
                System.out.println("iluminacion: " + iluminacion);
            }
        }

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("¿Está seguro que desea eliminar el jardín? Y:sí N:no");
        String in = input.next();
        if (in.equals("Y")) {
            EliminarJardinArchivo(nombreDuenoEliminar);
        } else if (in.equals("N")) {
            return;
        }
    }

    public static void EliminarJardinArchivo(String nombreDuenoEliminar) {

        JSONArray jardinesList = jardinesEliminar;

//      Removiendo por dueño en la lista de jardines
        for (int i = 0; i < jardinesList.size(); i++) {
            JSONObject jardinJSON = (JSONObject) jardinesList.get(i);
            String nombreDuenoi = (String) jardinJSON.get("nombreDueno");
            if (nombreDuenoEliminar.equals(nombreDuenoi)) {
                jardinesList.remove(i);
//                return;
            }
        }

        //Write JSON file
//        try (FileWriter file = new FileWriter(ruta + "usuarios.json", true)) {
        try (FileWriter file = new FileWriter(ruta + "jardines.json")) {

            file.write(jardinesList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

