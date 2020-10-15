import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeerPlantaJSON {

    public static String ruta = "src/main/resources/database/";
    public static JSONArray PlantaLeidos = new JSONArray();
    public static Scanner input = new Scanner(System.in);

    public static JSONArray LeerPlanta(){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(ruta + "Planta.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray Listaplanta = (JSONArray) obj;
            for (Object plantaObjeto : Listaplanta) {
                JSONObject plantaJSON = (JSONObject) plantaObjeto;
                PlantaLeidos.add(plantaJSON);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return PlantaLeidos;
    }

    public static Planta parseUser(JSONObject plantaJSON) {

        int Referencia = (int) plantaJSON.get("referencia");
        String Genero = (String) plantaJSON.get("Genero");
        int Diametro = (int) plantaJSON.get("Diametro");
        int ProfundidadRaices = (int) plantaJSON.get("Profundidad de raices");
        String RequerimientoIluminacion = (String) plantaJSON.get("Requerimiento de iluminacion");
        int Cantidad = (int) plantaJSON.get("Cantidad");
        int Costo = (int) plantaJSON.get("Costo");

        Planta PlantaLeidos = new Planta(Referencia, Genero, Diametro, ProfundidadRaices,RequerimientoIluminacion,Cantidad,Costo);

        return PlantaLeidos;
    }
}