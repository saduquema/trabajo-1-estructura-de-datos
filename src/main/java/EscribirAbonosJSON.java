import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirAbonosJSON {

    public static Scanner input = new Scanner(System.in);
    public static String ruta = "src/main/resources/database/";

    public static void EscribirAbono() {

        //Solicitud de datos del nuevo usuario
        System.out.println("Ingrese la referencia del nuevo abono: ");
        int referencia = input.nextInt();

        System.out.println("Ingrese el tipo o el origen del abono: ");
        String tipoOrigen = input.next();

        System.out.println("Ingrese la funcionalidad: ");
        String funcionalidad = input.next();

        System.out.println("Ingrese la presentacion: ");
        String presentacion = input.next();

        System.out.println("Ingrese el costo: ");
        int costo = input.nextInt();


        //Convirtiendo a objeto Usuario
        JSONObject userDetails = new JSONObject();
        userDetails.put("referencia", referencia);
        userDetails.put("material", tipoOrigen);
        userDetails.put("diametro", funcionalidad);
        userDetails.put("profundidad", presentacion);
        userDetails.put("cantidad", costo);


        //Add employee to list
        JSONArray abonosList = LeerAbonosJSON.leerAbonos();

//      Verificando que no exista el mismo abono
        for (Object abonoObjeto : abonosList) {
            JSONObject abonoJSON = (JSONObject) abonoObjeto;
            int referenciai = (int) abonoJSON.get("referencia");
            if (referencia == (referencia)) {
                System.out.println("el abono con esa referencia ya existe");
                return;
            }
        }

        abonosList.add(userDetails);


        //Write JSON file
//        try (FileWriter file = new FileWriter(ruta + "usuarios.json", true)) {
        try (FileWriter file = new FileWriter(ruta + "abonos.json")) {

            file.write(abonosList.toJSONString());
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