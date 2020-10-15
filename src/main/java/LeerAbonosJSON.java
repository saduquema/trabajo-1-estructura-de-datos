import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerAbonosJSON {

    public static String ruta = "src/main/resources/database/";
    //    public static ArrayList<Abonos> abonosLeidos = new ArrayList<>();
    public static JSONArray abonosLeidos = new JSONArray();


    //    public static ArrayList<Abonos> leerAbonos() {
    public static JSONArray leerAbonos() {

        // JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(ruta + "abonos.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray listaAbonos = (JSONArray) obj;

            // Iterate over employee array
            for(Object abonosObjeto : listaAbonos){
                JSONObject abonosJSON = (JSONObject) abonosObjeto;
//                abonosLeidos.add(parseUser(abonosJSON));
                abonosLeidos.add(abonosJSON);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return abonosLeidos;
    }

    public static Maceta parseUser(JSONObject abonoJSON){

//        JSONObject atributos = (JSONObject) abonoJSON.get("Abono");
//        System.out.println("hola" + atributos);
        int referencia = ((int) abonoJSON.get("referencia"));
        String tipoOrigen = (String) abonoJSON.get("tipo/origen");
        String funcionalidad   = (String) abonoJSON.get("funcionalidad");
        String presentacion = (String) abonoJSON.get("presentacion");
        int costo = ((int) abonoJSON.get("costo"));


        Abono abonosLeidos = new Abono(referencia, tipoOrigen, funcionalidad, presentacion, costo);

        return abonosLeidos;
    }
}