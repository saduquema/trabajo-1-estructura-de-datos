import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeerPlagaJSON {

    public static String ruta = "src/main/resources/database/";
    public static JSONArray PlagaLeidos = new JSONArray();
    public static Scanner input = new Scanner(System.in);

    public static JSONArray LeerPlaga(){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(ruta + "Plagas.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray Listaplagas = (JSONArray) obj;
            for (Object plagaObjeto : Listaplagas) {
                JSONObject plagaJSON = (JSONObject) plagaObjeto;
                PlagaLeidos.add(plagaJSON);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return PlagaLeidos;
    }

    public static Plaga parseUser(JSONObject plagaJSON) {

        int Referencia = (int) plagaJSON.get("referencia");
        String Organismo = (String) plagaJSON.get("Organismo");
        int Cantidad = (int) plagaJSON.get("Cantidad");
        String Remedio = (String) plagaJSON.get("Remedio");

        Plaga PlagaLeidos = new Plaga(Referencia, Organismo, Cantidad, Remedio);

        return PlagaLeidos;
    }
}


