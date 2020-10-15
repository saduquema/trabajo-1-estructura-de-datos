import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerSustratoJSON {

    public static String ruta = "src/main/resources/database/";
    public static JSONArray SustratosLeidos = new JSONArray();

    public static JSONArray LeerSustrato(){

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(ruta + "Sustratos.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray ListaSustratos = (JSONArray) obj;

            for (Object sustratoObjeto : ListaSustratos) {
                JSONObject sustratoJSON = (JSONObject) sustratoObjeto;
                SustratosLeidos.add(sustratoJSON);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return SustratosLeidos;
    }

    public static Sustrato parseUser(JSONObject usuarioJSON) {

        long Referencia = ((long) usuarioJSON.get("referencia"));
        long PorcentajeDeTierra = (long) usuarioJSON.get("porcentaje de tierra");
        long PorcentajeDeMinerales = (long) usuarioJSON.get("porcentaje de minerales");
        long PorcentajeDeAbono = (long) usuarioJSON.get("porcentaje de abono");
        long Costo = (long) usuarioJSON.get("costo");

        Sustrato SustratosLeido = new Sustrato(Referencia, PorcentajeDeTierra, PorcentajeDeMinerales, PorcentajeDeAbono, Costo);

        return SustratosLeido;
    }

}
