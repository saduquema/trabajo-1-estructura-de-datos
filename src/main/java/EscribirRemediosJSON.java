import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirRemediosJSON {

    public static Scanner input = new Scanner(System.in);
    public static String ruta = "src/main/resources/database/";

    public static void EscribirRemedio() {

        //Solicitud de datos del nuevo usuario
        System.out.println("Ingrese la referencia del nuevo remedio: ");
        long referencia = input.nextLong();

        System.out.println("Ingrese el tipo o el origen del remedio: ");
        String tipoOrigen = input.next();

        System.out.println("Ingrese la funcionalidad: ");
        String funcionalidad = input.next();

        System.out.println("Ingrese la presentacion: ");
        String presentacion = input.next();

        System.out.println("Ingrese el costo: ");
        long costo = input.nextLong();


        //Convirtiendo a objeto Usuario
        JSONObject userDetails = new JSONObject();
        userDetails.put("referencia", referencia);
        userDetails.put("tipoOrigen", tipoOrigen);
        userDetails.put("funcionalidad", funcionalidad);
        userDetails.put("presentacion", presentacion);
        userDetails.put("costo", costo);


        //Add employee to list
        JSONArray remediosList = LeerRemediosJSON.leerRemedios();

//      Verificando que no exista el mismo remedio
        for (Object remedioObjeto : remediosList) {
            JSONObject remedioJSON = (JSONObject) remedioObjeto;
            long referenciai = (long) remedioJSON.get("referencia");
            if (referenciai == (referencia)) {
                System.out.println("el remedio con esa referencia ya existe");
                return;
            }
        }

        remediosList.add(userDetails);


        //Write JSON file
//        try (FileWriter file = new FileWriter(ruta + "remedios.json", true)) {
        try (FileWriter file = new FileWriter(ruta + "remedios.json")) {

            file.write(remediosList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}