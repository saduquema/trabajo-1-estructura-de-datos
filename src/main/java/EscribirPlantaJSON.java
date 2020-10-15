import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirPlantaJSON {

    public static String ruta = "src/main/resources/database/";
    public static Scanner input = new Scanner(System.in);

    public static void EscribirPlanta() {

        System.out.println("Ingrese los datos de la nueva planta:");

        System.out.println("Ingrese la referencia:");
        int Referencia = input.nextInt();

        System.out.println("Ingrese el genero de la planta:");
        String Genero = input.next();

        System.out.println("Ingrese el diametro de la planta:");
        int Diametro  = input.nextInt();

        System.out.println("ingrese la profundidad de raices de la planta:");
        int ProfundidadRaices = input.nextInt();

        System.out.println("ingrese el requerimiento de iluminacion:");
        String RequerimientoIluminacion = input.next();

        System.out.println("ingrese la cantidad de la/s planta/S:");
        int Cantidad = input.nextInt();

        System.out.println("ingrese el costo de la/s planta/s:");
        int Costo = input.nextInt();

        JSONObject plantaDetails = new JSONObject();
        plantaDetails.put("Referencia", Referencia);
        plantaDetails.put("Genero", Genero);
        plantaDetails.put("Diametro", Diametro);
        plantaDetails.put("Profundidad de raices", ProfundidadRaices);
        plantaDetails.put("Requerimiento de iluminacion", RequerimientoIluminacion);
        plantaDetails.put("Cantidad", Cantidad);
        plantaDetails.put("Costo", Costo);

        JSONArray plantaList = LeerPlantaJSON.LeerPlanta();
        plantaList.add(plantaDetails);

        try (FileWriter file = new FileWriter(ruta + "Planta.json")) {
            file.write(plantaList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
