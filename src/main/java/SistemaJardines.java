import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaJardines {

    public static Scanner input = new Scanner(System.in);
//    public static ArrayList <Usuario> usuariosCargados = LeerUsuariosJSON.leerUsuarios();
//    public static ArrayList <Usuario> usuariosLeidos = LeerUsuariosJSON.leerUsuarios();
    public static ArrayList <Usuario> usuariosLeidos = new ArrayList<>();
    public static ArrayList <Usuario> usuariosCargados = new ArrayList<>();
    public static ArrayList <Usuario> usuariosEscritos = new ArrayList<>();

    public static void main(String[] args) {

//        LeerJSON.leer();
//        JSONArray usuariosCargados = LeerJSON.leerUsuarios();


        System.out.println(usuariosLeidos);
        System.out.println(usuariosCargados);


        //Menú inicial - usuario
        String option;

        while (true) {
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Buenas, bienvenido al sistema de diseño de jardines");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Autenticarse");
            System.out.println("2. Registrarse");
            System.out.println("0. Salir");
            System.out.println();

            option = input.next();
            if (option.equals("1")) {
            autenticarUsuario();
            } else if (option.equals("2")) {
            registrarUsuario();
            } else if (option.equals("0")) {
                break;
            }
        }
    }

    public static void autenticarUsuario() {

        ArrayList <Usuario> usuariosLeidos = LeerUsuariosJSON.leerUsuarios();

        for(Object usuarioObjeto : usuariosLeidos){
            JSONObject usuarioJSON = (JSONObject) usuarioObjeto;
            usuariosCargados.add(LeerUsuariosJSON.parseUser(usuarioJSON));
        }

        System.out.println(usuariosCargados);

        System.out.println("Ingrese su documento/correo");
        String identificacion = input.next();

        System.out.println("Ingrese su contraseña");
        String clave = input.next();

//        Verificar si es documento o correo lo que se ingresó
        boolean hayArroba = identificacion.matches(".*[@].*");
//        System.out.println(hayArroba);
        boolean esnumero = identificacion.matches("[0-9]*");
//        System.out.println(esnumero);

        String email = "";
        int id = 0;

        if (hayArroba == true) {
            email = identificacion;
//            System.out.println("es correo");
        }

        else if (esnumero == true) {
            id = Integer.parseInt((String) identificacion);
//            System.out.println("es número");
        }

        boolean existeUsuario = false;

//        Verificación de que existe el documento/correo y contraseña ingresados
        for (Usuario usuarioCargado : usuariosCargados) {

//            if (id.equals(+usuarioCargado.documento) || email.equals(usuarioCargado.correo)) {
            if ((id == usuarioCargado.documento) || email.equals(usuarioCargado.correo)) {
                if (clave.equals(usuarioCargado.contrasena)) {
                    existeUsuario = true;
                    System.out.println("Validación correcta");
                    return;
                }
                else {
                    System.out.println("contraseña incorrecta");
                    return;
                }
            }
        }

        if (existeUsuario == false){
            System.out.println("documento/correo no existe");
        }
    }


    public static void registrarUsuario() {
//        usuariosCargados.add(EscribirUsuariosJSON.EscribirUsuario());

        EscribirUsuariosJSON.EscribirUsuario();

//        ArrayList <Usuario> usuariosLeidos = new ArrayList<>();
        ArrayList <Usuario> usuariosLeidos = LeerUsuariosJSON.leerUsuarios();

        for(Object usuarioObjeto : usuariosLeidos){
            JSONObject usuarioJSON = (JSONObject) usuarioObjeto;
            usuariosEscritos.add(LeerUsuariosJSON.parseUser(usuarioJSON));
        }

        System.out.println(usuariosLeidos);
        System.out.println(usuariosCargados);
        System.out.println(usuariosEscritos);
    }








    public static void menuPrincipal() {

        //Menú principal - clases
        String option;

        while (true) {
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Menú principal, sistema de diseño de jardines");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Jardines");
            System.out.println("2. Macetas");
            System.out.println("3. Sustratos");
            System.out.println("4. Plantas");
            System.out.println("5. Abonos");
            System.out.println("6. Plagas");
            System.out.println("7. Remedios");
            System.out.println("0. Salir");
            System.out.println();

            option = input.next();
            if (option.equals("1")) {
                crudJardines();
            } else if (option.equals("2")) {
//                crudMacetas();
            } else if (option.equals("3")) {
//                crudSustratos();
            } else if (option.equals("4")) {
//                crudPlantas();
            } else if (option.equals("5")) {
//                crudAbonos();
            } else if (option.equals("6")) {
//                crudPlagas();
            } else if (option.equals("7")) {
//                crudRemedios();
            } else if (option.equals("0")) {
                break;
            }
        }
    }

    public static void crudJardines() {

        String option;

        while (true) {
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver");
            System.out.println("2. Crear");
            System.out.println("3. Editar");
            System.out.println("4. Eliminar");
            System.out.println("0. Retornar al menú anterior");
            System.out.println();

            option = input.next();
            if (option.equals("1")) {
//                ver();
            } else if (option.equals("2")) {
//                crear();
            } else if (option.equals("3")) {
//                editar();
            } else if (option.equals("4")) {
//                eliminar();
            } else if (option.equals("0")) {
                break;
            }

        }
    }
}
