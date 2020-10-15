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
        int referencia = input.nextInt();

        System.out.println("Ingrese el tipo o el origen del remedio: ");
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
        JSONArray remediosList = LeerRemediosJSON.leerRemedios();

//      Verificando que no exista el mismo remedio
        for (Object remedioObjeto : remediosList) {
            JSONObject remedioJSON = (JSONObject) remedioObjeto;
            int referenciai = (int) remedioJSON.get("referencia");
            if (referencia == (referencia)) {
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