import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerRemediosJSON {

    public static String ruta = "src/main/resources/database/";
    //    public static ArrayList<Remedios> remediosLeidos = new ArrayList<>();
    public static JSONArray remediosLeidos = new JSONArray();


    //    public static ArrayList<Remedios> leerRemedios() {
    public static JSONArray leerRemedios() {

        // JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(ruta + "remedios.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray listaRemedios = (JSONArray) obj;

            // Iterate over employee array
            for(Object remediosObjeto : listaRemedios){
                JSONObject remediosJSON = (JSONObject) remediosObjeto;
//                remediosLeidos.add(parseUser(remediosJSON));
                remediosLeidos.add(remediosJSON);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return remediosLeidos;
    }

    public static Remedio parseUser(JSONObject remedioJSON){

//        JSONObject atributos = (JSONObject) remedioJSON.get("remedio");
//        System.out.println("hola" + atributos);
        long referencia = ((long) remedioJSON.get("referencia"));
        String tipoOrigen = (String) remedioJSON.get("tipoOrigen");
        String funcionalidad   = (String) remedioJSON.get("funcionalidad");
        String presentacion = (String) remedioJSON.get("presentacion");
        long costo = ((long) remedioJSON.get("costo"));


        Remedio remediosLeidos = new Remedio(referencia, tipoOrigen, funcionalidad, presentacion, costo);

        return remediosLeidos;
    }
}