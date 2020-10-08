import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class LectorJSON {
    public static String ruta = "src/main/resources/database/";
    public static TreeMap<Integer,Usuario> leerUsuariosJsonTreeSet(){
        TreeMap<Integer,Usuario> usuariosLeidos = new TreeMap<>();
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(ruta+"UsuariosJSON.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray ListaUsuarios = (JSONArray)obj ;
            for(Object usuarioObjeto : ListaUsuarios){
                JSONObject usuarioJSON = (JSONObject) usuarioObjeto;
                usuariosLeidos.put(extractorCedula(usuarioJSON),parseUsuario(usuarioJSON));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return usuariosLeidos;
    }

    public static ArrayList<Usuario> leerUsuariosJsonArrayList(){
        ArrayList<Usuario> usuariosLeidos = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(ruta+"UsuariosJSON.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray ListaUsuarios = (JSONArray)obj ;
            for(Object usuarioObjeto : ListaUsuarios){
                JSONObject usuarioJSON = (JSONObject) usuarioObjeto;
                usuariosLeidos.add(parseUsuario(usuarioJSON));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return usuariosLeidos;
    }
    private static Usuario parseUsuario(JSONObject usuarioJSON)
    {
        JSONObject atributos = (JSONObject) usuarioJSON.get("Usuario");
        int cedula = Integer.parseInt((String) atributos.get("cedula"));
        String nombre = (String) atributos.get("nombre");
        int edad = Integer.parseInt((String) atributos.get("edad"));
        Usuario usuarioLeido = new Usuario(cedula,nombre,edad);
        return usuarioLeido;
    }

    private static int extractorCedula (JSONObject usuarioJSON)
    {
        JSONObject atributos = (JSONObject) usuarioJSON.get("Usuario");
        int cedula = Integer.parseInt((String) atributos.get("cedula"));
        return cedula;
    }
}
