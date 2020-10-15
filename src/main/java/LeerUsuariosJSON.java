import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LeerUsuariosJSON {

    public static String ruta = "src/main/resources/database/";
//    public static ArrayList<Usuario> usuariosLeidos = new ArrayList<>();
    public static JSONArray usuariosLeidos = new JSONArray();


//    public static ArrayList<Usuario> leerUsuarios() {
    public static JSONArray leerUsuarios() {

        // JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(ruta + "usuarios.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray listaUsuarios = (JSONArray) obj;

            // Iterate over employee array
            for(Object usuarioObjeto : listaUsuarios){
                JSONObject usuarioJSON = (JSONObject) usuarioObjeto;
//                usuariosLeidos.add(parseUser(usuarioJSON));
                usuariosLeidos.add(usuarioJSON);
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

    public static Usuario parseUser(JSONObject usuarioJSON){
        
        long documento = ((long) usuarioJSON.get("documento"));
        String nombre = (String) usuarioJSON.get("nombre");
        String apellido = (String) usuarioJSON.get("apellido");
        String correo = (String) usuarioJSON.get("correo");
        String contrasena = ((String) usuarioJSON.get("contrasena"));

        Usuario usuarioLeido = new Usuario(documento, nombre, apellido, correo, contrasena);

        return usuarioLeido;
    }

//    public static void parseUserObject(JSONObject user) {
//
//        // Get user id
//        long documento = (long) user.get("documento");
//        System.out.println(documento);
//
//        // Get user first name
//        String nombre = (String) user.get("nombre");
//        System.out.println(nombre);
//
//        // Get user last name
//        String apellido = (String) user.get("apellido");
//        System.out.println(apellido);
//
//        // Get user email name
//        String correo = (String) user.get("correo");
//        System.out.println(correo);
//
//        // Get user password
//        String contrasena = (String) user.get("contrasena");
//        System.out.println(contrasena);
//    }
}
