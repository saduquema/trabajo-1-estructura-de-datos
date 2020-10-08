import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.util.Random;

public class EscribirJSON {
    public static String ruta = "src/main/resources/database/";

    public static void generarJSON(){
        JSONArray UsuarioLista = new JSONArray();
        for (int i = 0; i < 1000000; i++) {
            JSONObject UsuarioDatos = new JSONObject();
            UsuarioDatos.put("cedula",generadorCedulas());
            UsuarioDatos.put("nombre", generadorDeNombres());
            UsuarioDatos.put("edad", generadorEdad());
            JSONObject UsuarioPerfil = new JSONObject();
            UsuarioPerfil.put("Usuario", UsuarioDatos);

            UsuarioLista.add(UsuarioPerfil);
        }


        try (FileWriter file = new FileWriter(ruta+"UsuariosJSON.json")) {
            file.write(UsuarioLista.toJSONString());
            file.flush();
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
    }

    public static String generadorDeNombres(){
        int longitudNombre= 8;
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder(longitudNombre);
        Random random = new Random();
        for (int i = 0; i < longitudNombre; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static String generadorCedulas(){
        int longitudCedula= 8;
        char[] chars = "0123456789".toCharArray();
        StringBuilder sb = new StringBuilder(longitudCedula);
        Random random = new Random();
        for (int i = 0; i < longitudCedula; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static String generadorEdad(){
        int longitudEdad= 2;
        char[] chars = "0123456789".toCharArray();
        StringBuilder sb = new StringBuilder(longitudEdad);
        Random random = new Random();
        for (int i = 0; i < longitudEdad; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return String.valueOf(Integer.parseInt(sb.toString()));
    }

}
