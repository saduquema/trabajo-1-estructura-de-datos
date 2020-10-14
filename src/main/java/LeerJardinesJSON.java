import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerJardinesJSON {

    public static String ruta = "src/main/resources/database/";
    public static JSONArray jardinesLeidos = new JSONArray();

    public static JSONArray leerJardines() {

        // JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(ruta + "jardines.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray listaJardines = (JSONArray) obj;

            // Iterate over employee array
            for (Object jardinObjeto : listaJardines) {
                JSONObject jardinJSON = (JSONObject) jardinObjeto;
                jardinesLeidos.add(jardinJSON);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return jardinesLeidos;
    }

    public static Jardin parseUser(JSONObject usuarioJSON) {

        String nombreDueno = (String) usuarioJSON.get("nombreDueno");
        long area = ((long) usuarioJSON.get("area"));
        String ambiente = (String) usuarioJSON.get("ambiente");
        long temperaturaPromedio = ((long) usuarioJSON.get("temperaturaPromedio"));
        String iluminacion = ((String) usuarioJSON.get("iluminacion"));

        Jardin jardinLeido = new Jardin(nombreDueno, area, ambiente, temperaturaPromedio, iluminacion);

        return jardinLeido;
    }

}
