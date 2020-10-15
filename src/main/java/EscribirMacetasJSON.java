import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirMacetasJSON {

    public static Scanner input = new Scanner(System.in);
    public static String ruta = "src/main/resources/database/";

    public static void EscribirMaceta() {

        //Solicitud de datos del nuevo usuario
        System.out.println("Ingrese la referencia de la nueva maceta: ");
        int referencia = input.nextInt();

        System.out.println("Ingrese el material: ");
        String material = input.next();

        System.out.println("Ingrese el diametro: ");
        int diametro = input.nextInt();

        System.out.println("Ingrese la profundidad: ");
        int profundidad = input.nextInt();

        System.out.println("Ingrese la cantidad: ");
        int cantidad = input.nextInt();

        System.out.println("Ingrese el costoUnitario: ");
        int costoUnitario = input.nextInt();

        //Convirtiendo a objeto Usuario
        JSONObject userDetails = new JSONObject();
        userDetails.put("referencia", referencia);
        userDetails.put("material", material);
        userDetails.put("diametro", diametro);
        userDetails.put("profundidad", profundidad);
        userDetails.put("cantidad", cantidad);
        userDetails.put("costoUnitario", costoUnitario);

        //Add employee to list
        JSONArray jardinesList = LeerMacetasJSON.leerMacetas();

//      Verificando que no exista el mismo nombre del dueño en la lista de jardines
        for (Object jardinObjeto : jardinesList) {
            JSONObject jardinJSON = (JSONObject) jardinObjeto;
            int referenciai = (int) jardinJSON.get("referencia");
            if (referencia == (referencia)) {
                System.out.println("La maceta con esa referencia ya existe");
                return;
            }
        }

        jardinesList.add(userDetails);


        //Write JSON file
//        try (FileWriter file = new FileWriter(ruta + "usuarios.json", true)) {
        try (FileWriter file = new FileWriter(ruta + "jardines.json")) {

            file.write(jardinesList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    private static Usuario parseUser(JSONObject usuarioJSON) {
//
//        long documento = ((long) usuarioJSON.get("documento"));
//        String nombre = (String) usuarioJSON.get("nombre");
//        String apellido = (String) usuarioJSON.get("apellido");
//        String correo = (String) usuarioJSON.get("correo");
//        String contrasena = ((String) usuarioJSON.get("contrasena"));
//
//        Usuario usuarioEscrito = new Usuario(documento, nombre, apellido, correo, contrasena);
//
//        return usuarioEscrito;
//    }
}