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
        long referencia = input.nextLong();

        System.out.println("Ingrese el material: ");
        String material = input.next();

        System.out.println("Ingrese el diametro: ");
        long diametro = input.nextLong();

        System.out.println("Ingrese la profundidad: ");
        long profundidad = input.nextLong();

        System.out.println("Ingrese la cantidad: ");
        long cantidad = input.nextInt();

        System.out.println("Ingrese el costoUnitario: ");
        long costoUnitario = input.nextLong();

        //Convirtiendo a objeto Usuario
        JSONObject userDetails = new JSONObject();
        userDetails.put("referencia", referencia);
        userDetails.put("material", material);
        userDetails.put("diametro", diametro);
        userDetails.put("profundidad", profundidad);
        userDetails.put("cantidad", cantidad);
        userDetails.put("costoUnitario", costoUnitario);

        //Add employee to list
        JSONArray macetasList = LeerMacetasJSON.leerMacetas();

//      Verificando que no exista la misma maceta
        for (Object macetaObjeto : macetasList) {
            JSONObject macetaJSON = (JSONObject) macetaObjeto;
            long referenciai = (long) macetaJSON.get("referencia");
            if (referenciai == referencia) {
                System.out.println("La maceta con esa referencia ya existe");
                return;
            }
        }

        macetasList.add(userDetails);


        //Write JSON file
//        try (FileWriter file = new FileWriter(ruta + "usuarios.json", true)) {
        try (FileWriter file = new FileWriter(ruta + "macetas.json")) {

            file.write(macetasList.toJSONString());
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