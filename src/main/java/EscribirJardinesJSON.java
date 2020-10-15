import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirJardinesJSON {

    public static Scanner input = new Scanner(System.in);
    public static String ruta = "src/main/resources/database/";

    public static void EscribirJardin() {

        //Solicitud de datos del nuevo jardin
        System.out.println("Ingrese los datos del nuevo jardín:");
        System.out.println("Ingrese el nombre del dueño del jardín");
        String nombreDueno = input.next();

        System.out.println("Ingrese el área en m2:");
        long area = input.nextLong();

        System.out.println("Ingrese el ambiente (húmedo, seco, parcial/.):");
        String ambiente = input.next();

        System.out.println("Ingrese la temperatura promedio en °C:");
        long temperaturaPromedio = input.nextLong();

        System.out.println("Ingrese la iluminación (soleado, iluminado, parcial/.:");
        String iluminacion = input.next();

        //Convirtiendo a objeto Usuario
        JSONObject userDetails = new JSONObject();
        userDetails.put("nombreDueno", nombreDueno);
        userDetails.put("area", area);
        userDetails.put("ambiente", ambiente);
        userDetails.put("temperaturaPromedio", temperaturaPromedio);
        userDetails.put("iluminacion", iluminacion);

        //Add employee to list
        JSONArray jardinesList = LeerJardinesJSON.leerJardines();

//      Verificando que no exista el mismo nombre del dueño en la lista de jardines
        for (Object jardinObjeto : jardinesList) {
            JSONObject jardinJSON = (JSONObject) jardinObjeto;
            String nombreDuenoi = (String) jardinJSON.get("nombreDueno");
            if (nombreDueno.equals(nombreDuenoi)) {
                System.out.println("El nombre del Jardín/Dueño ya existe");
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
