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
        long Referencia = input.nextLong();

        System.out.println("Ingrese el genero de la planta:");
        String Genero = input.next();

        System.out.println("Ingrese el diametro de la planta:");
        long Diametro  = input.nextLong();

        System.out.println("ingrese la profundidad de raices de la planta:");
        long ProfundidadRaices = input.nextLong();

        System.out.println("ingrese el requerimiento de iluminacion:");
        String RequerimientoIluminacion = input.next();

        System.out.println("ingrese la cantidad de la/s planta/S:");
        long Cantidad = input.nextLong();

        System.out.println("ingrese el costo de la/s planta/s:");
        long Costo = input.nextLong();

        JSONObject plantaDetails = new JSONObject();
        plantaDetails.put("Referencia", Referencia);
        plantaDetails.put("Genero", Genero);
        plantaDetails.put("Diametro", Diametro);
        plantaDetails.put("ProfundidadRaices", ProfundidadRaices);
        plantaDetails.put("RequerimientoIluminacion", RequerimientoIluminacion);
        plantaDetails.put("Cantidad", Cantidad);
        plantaDetails.put("Costo", Costo);

        JSONArray plantaList = LeerPlantaJSON.LeerPlanta();

        for (Object plantaObjeto : plantaList) {
            JSONObject plantaJSON = (JSONObject) plantaObjeto;
            long Referenciai = (long) plantaJSON.get("Referencia");
            if (Referenciai == Referencia) {
                System.out.println("La planta con esa referencia ya existe");
                return;
            }
        }
        plantaList.add(plantaDetails);

        try (FileWriter file = new FileWriter(ruta + "Planta.json")) {
            file.write(plantaList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
