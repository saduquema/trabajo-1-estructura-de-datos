import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EscribirUsuariosJSON {

    public static Scanner input = new Scanner(System.in);
    public static String ruta = "src/main/resources/database/";

    //    public static void main(String[] args) {
//public static Usuario EscribirUsuario (){
    public static void EscribirUsuario() {

        //Solicitud de datos del nuevo usuario
        System.out.println("Ingrese los datos del nuevo usuario:");
        System.out.println("Ingrese el documento:");
        long documento = input.nextLong();

        System.out.println("Ingrese el nombre:");
        String nombre = input.next();

        System.out.println("Ingrese el apellido:");
        String apellido = input.next();

        System.out.println("Ingrese el correo:");
        String correo = input.next();

        System.out.println("Ingrese la contraseña:");
        String contrasena = input.next();

        //Convirtiendo a objeto Usuario
        JSONObject userDetails = new JSONObject();
        userDetails.put("documento", documento);
        userDetails.put("nombre", nombre);
        userDetails.put("apellido", apellido);
        userDetails.put("correo", correo);
        userDetails.put("contrasena", contrasena);

//        Usuario UsuarioEscrito = parseUser(userDetails);
//        return UsuarioEscrito;


        //Add employees to list
//        ArrayList<Usuario> usuariosCargados = LeerUsuariosJSON.leerUsuarios();
//        ArrayList<Usuario> usuariosCargados = LeerUsuariosJSON.leerUsuarios();

//        JSONArray userList = new JSONArray();
//        for (int i=0; i < usuariosCargados.size(); i++) {
//            userList.add(usuariosCargados.get(i));
//        }

//        JSONArray userList = new JSONArray();
        JSONArray userList = LeerUsuariosJSON.leerUsuarios();
//        for(Object usuarioObjeto : usuariosCargados){
//            JSONObject usuarioJSON = (JSONObject) usuarioObjeto;
//            userList.add(parseUser(usuarioJSON));
//        }

        userList.add(userDetails);


        //Write JSON file
//        try (FileWriter file = new FileWriter(ruta + "usuarios.json", true)) {
        try (FileWriter file = new FileWriter(ruta + "usuarios.json")) {

            file.write(userList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static Usuario parseUser(JSONObject usuarioJSON) {

//        JSONObject atributos = (JSONObject) usuarioJSON.get("Usuario");
//        System.out.println("hola" + atributos);
        long documento = ((long) usuarioJSON.get("documento"));
        String nombre = (String) usuarioJSON.get("nombre");
        String apellido = (String) usuarioJSON.get("apellido");
        String correo = (String) usuarioJSON.get("correo");
        String contrasena = ((String) usuarioJSON.get("contrasena"));

        Usuario usuarioEscrito = new Usuario(documento, nombre, apellido, correo, contrasena);

        return usuarioEscrito;
    }


}
