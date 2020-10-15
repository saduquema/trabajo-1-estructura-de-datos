import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LeerMacetasJSON {

    public static String ruta = "src/main/resources/database/";
    //    public static ArrayList<Macetas> macetasLeidas = new ArrayList<>();
    public static JSONArray macetasLeidas = new JSONArray();


    //    public static ArrayList<Macetas> leerMacetas() {
    public static JSONArray leerMacetas() {

        // JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(ruta + "macetas.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray listaMacetas = (JSONArray) obj;

            // Iterate over employee array
            for(Object macetasObjeto : listaMacetas){
                JSONObject macetasJSON = (JSONObject) macetasObjeto;
//                macetasLeidas.add(parseUser(macetasJSON));
                macetasLeidas.add(macetasJSON);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return macetasLeidas;
    }

    public static Maceta parseUser(JSONObject macetaJSON){

//        JSONObject atributos = (JSONObject) macetaJSON.get("Maceta");
//        System.out.println("hola" + atributos);
        long referencia = ((long) macetaJSON.get("referencia"));
        String material = (String) macetaJSON.get("material");
        long diametro = (long) macetaJSON.get("diametro");
        long profundidad = ((long) macetaJSON.get("profundidad"));
        long cantidad = ((long) macetaJSON.get("cantidad"));
        long costoUnitario = ((long) macetaJSON.get("costoUnitario"));

        Maceta macetasLeidas = new Maceta(referencia, material, diametro, profundidad, cantidad,costoUnitario);

        return macetasLeidas;
    }
}
