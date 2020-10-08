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
    public static TreeMap<Integer, UsuarioEjemplo> leerUsuariosJsonTreeSet(){
        TreeMap<Integer, UsuarioEjemplo> usuariosLeidos = new TreeMap<>();
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

    public static ArrayList<UsuarioEjemplo> leerUsuariosJsonArrayList(){
        ArrayList<UsuarioEjemplo> usuariosLeidos = new ArrayList<>();
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
    private static UsuarioEjemplo parseUsuario(JSONObject usuarioJSON)
    {
        JSONObject atributos = (JSONObject) usuarioJSON.get("Usuario");
        int cedula = Integer.parseInt((String) atributos.get("cedula"));
        String nombre = (String) atributos.get("nombre");
        int edad = Integer.parseInt((String) atributos.get("edad"));
        UsuarioEjemplo usuarioEjemploLeido = new UsuarioEjemplo(cedula,nombre,edad);
        return usuarioEjemploLeido;
    }

    private static int extractorCedula (JSONObject usuarioJSON)
    {
        JSONObject atributos = (JSONObject) usuarioJSON.get("Usuario");
        int cedula = Integer.parseInt((String) atributos.get("cedula"));
        return cedula;
    }
}
