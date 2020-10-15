import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaJardines {

    public static Scanner input = new Scanner(System.in);

//    public static ArrayList <Usuario> usuariosLeidos = new ArrayList<>();
    public static ArrayList <Usuario> usuariosLeidos =LeerUsuariosJSON.leerUsuarios();
    public static ArrayList <Usuario> usuariosCargados = new ArrayList<>();
    public static ArrayList <Usuario> usuariosEscritos = new ArrayList<>();
    public static ArrayList <Jardin> jardinesLeidos =LeerJardinesJSON.leerJardines();
    public static ArrayList <Jardin> jardinesCargados = new ArrayList<>();
    public static ArrayList <Jardin> jardinesEscritos = new ArrayList<>();
    public static ArrayList<Jardin> jardinesEditados = new ArrayList<>();
    public static ArrayList<Jardin> jardinesEliminados = new ArrayList<>();
    public static ArrayList <Maceta> macetasLeidos =LeerMacetasJSON.leerMacetas();
    public static ArrayList <Maceta> macetasCargados = new ArrayList<>();
    public static ArrayList <Maceta> macetasEscritos = new ArrayList<>();
    public static ArrayList<Maceta> macetasEditados = new ArrayList<>();
    public static ArrayList<Maceta> macetasEliminados = new ArrayList<>();
    public static ArrayList <Sustrato> sustratosLeidos =LeerSustratoJSON.LeerSustrato();
    public static ArrayList <Sustrato> sustratosCargados = new ArrayList<>();
    public static ArrayList <Sustrato> sustratosEscritos = new ArrayList<>();
    public static ArrayList <Planta> plantasLeidos =LeerPlantaJSON.LeerPlanta();
    public static ArrayList <Planta> plantasCargados = new ArrayList<>();
    public static ArrayList <Planta> plantasEscritos = new ArrayList<>();
    public static ArrayList <Abono> abonosLeidos =LeerAbonosJSON.leerAbonos();
    public static ArrayList <Abono> abonosCargados = new ArrayList<>();
    public static ArrayList <Abono> abonosEscritos = new ArrayList<>();
    public static ArrayList<Abono> abonosEditados = new ArrayList<>();
    public static ArrayList<Abono> abonosEliminados = new ArrayList<>();
    public static ArrayList <Plaga> plagasLeidos =LeerPlagaJSON.LeerPlaga();
    public static ArrayList <Plaga> plagasCargados = new ArrayList<>();
    public static ArrayList <Plaga> plagasEscritos = new ArrayList<>();
    public static ArrayList <Remedio> remediosLeidos =LeerRemediosJSON.leerRemedios();
    public static ArrayList <Remedio> remediosCargados = new ArrayList<>();
    public static ArrayList <Remedio> remediosEscritos = new ArrayList<>();
    public static ArrayList<Remedio> remediosEditados = new ArrayList<>();
    public static ArrayList<Remedio> remediosEliminados = new ArrayList<>();
    public static void main(String[] args) {

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

        //        usuariosLeidos = LeerUsuariosJSON.leerUsuarios();

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

            if ((id == usuarioCargado.documento) || email.equals(usuarioCargado.correo)) {
                if (clave.equals(usuarioCargado.contrasena)) {
                    existeUsuario = true;
                    System.out.println("Validación correcta");
                    System.out.println("¡Hola " + usuarioCargado.nombre + "!");
                    menuPrincipal();
                    usuariosLeidos.clear();
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

        usuariosLeidos.clear();
        usuariosEscritos.clear();

//      Escribe el usuario nuevo en el archivo json
        EscribirUsuariosJSON.EscribirUsuario();

//        usuariosLeidos = LeerUsuariosJSON.leerUsuarios();

//        System.out.println(usuariosLeidos);

        for(Object usuarioObjeto : usuariosLeidos){
            JSONObject usuarioJSON = (JSONObject) usuarioObjeto;
            usuariosEscritos.add(LeerUsuariosJSON.parseUser(usuarioJSON));
        }

//        System.out.println(usuariosLeidos);
//        System.out.println(usuariosCargados);
        System.out.println(usuariosEscritos);
    }



    public static void menuPrincipal() {

        //Menú principal - clases
        String option;

        while (true) {
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Menú principal, sistema de diseño de jardines");
            System.out.println("Escoja una opción:");
            System.out.println("1. Jardines");
            System.out.println("2. Macetas");
            System.out.println("3. Sustratos");
            System.out.println("4. Plantas");
            System.out.println("5. Abonos");
            System.out.println("6. Plagas");
            System.out.println("7. Remedios");
            System.out.println("0. Retornar al menú anterior");
            System.out.println();

            option = input.next();
            if (option.equals("1")) {
                crudJardines();
            } else if (option.equals("2")) {
                crudMacetas();
            } else if (option.equals("3")) {
                crudSustratos();
            } else if (option.equals("4")) {
                crudPlantas();
            } else if (option.equals("5")) {
                crudAbonos();
            } else if (option.equals("6")) {
                crudPlagas();
            } else if (option.equals("7")) {
                crudRemedios();
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
            System.out.println("1. Ver Jardines");
            System.out.println("2. Crear Jardines");
            System.out.println("3. Editar Jardines");
            System.out.println("4. Eliminar Jardines");
            System.out.println("0. Retornar al menú anterior");
            System.out.println();

            option = input.next();
            if (option.equals("1")) {
                verJardines();
            } else if (option.equals("2")) {
                crearJardines();
            } else if (option.equals("3")) {
                editarJardines();
            } else if (option.equals("4")) {
                eliminarJardines();
            } else if (option.equals("0")) {
                break;
            }

        }
    }



    public static void verJardines(){

//        ArrayList <Jardin> jardinesLeidos = LeerJardinesJSON.leerJardines();

        for(Object jardinObjeto : jardinesLeidos){
            JSONObject jardinJSON = (JSONObject) jardinObjeto;
            jardinesCargados.add(LeerJardinesJSON.parseUser(jardinJSON));
        }

        System.out.println(jardinesCargados);

        jardinesLeidos.clear();
    }



    public static void crearJardines() {

        jardinesLeidos.clear();
        jardinesEscritos.clear();

//      Escribe el jardin nuevo en el archivo json
        EscribirJardinesJSON.EscribirJardin();

//        System.out.println(jardinesLeidos);

        for(Object jardinOjeto : jardinesLeidos){
            JSONObject jardinJSON = (JSONObject) jardinOjeto;
            jardinesEscritos.add(LeerJardinesJSON.parseUser(jardinJSON));
        }

//        System.out.println(usuariosLeidos);
//        System.out.println(usuariosCargados);
        System.out.println(jardinesEscritos);
    }

    public static void eliminarJardines () {
//
        jardinesLeidos.clear();
        jardinesEliminados.clear();
        EliminarJardinesJSON.EliminarJardines();

        for (Object jardinOjeto : jardinesLeidos) {
            JSONObject jardinJSON = (JSONObject) jardinOjeto;
            jardinesEliminados.add(LeerJardinesJSON.parseUser(jardinJSON));
        }

        System.out.println(jardinesEliminados);

    }

    public static void editarJardines() {

        jardinesLeidos.clear();
        jardinesEditados.clear();
        EditarJardinesJSON.EditarJardines();

        for (Object jardinOjeto : jardinesLeidos) {
            JSONObject jardinJSON = (JSONObject) jardinOjeto;
            jardinesEditados.add(LeerJardinesJSON.parseUser(jardinJSON));
        }

        System.out.println(jardinesEditados);
    }

    public static void crudMacetas() {

        String option;

        while (true) {
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver Macetas");
            System.out.println("2. Crear Macetas");
            System.out.println("3. Editar Macetas");
            System.out.println("4. Eliminar Macetas");
            System.out.println("0. Retornar al menú anterior");
            System.out.println();

            option = input.next();
            if (option.equals("1")) {
                verMacetas();
            } else if (option.equals("2")) {
                crearMacetas();
            } else if (option.equals("3")) {
                editarMacetas();
            } else if (option.equals("4")) {
                eliminarMacetas();
            } else if (option.equals("0")) {
                break;
            }

        }
    }



    public static void verMacetas(){

//        ArrayList <Jardin> jardinesLeidos = LeerJardinesJSON.leerJardines();

        for(Object macetaObjeto : macetasLeidos){
            JSONObject macetaJSON = (JSONObject) macetaObjeto;
            macetasCargados.add(LeerMacetasJSON.parseUser(macetaJSON));
        }

        System.out.println(macetasCargados);

        macetasLeidos.clear();
    }



    public static void crearMacetas() {

        macetasLeidos.clear();
        macetasEscritos.clear();

//      Escribe el jardin nuevo en el archivo json
        EscribirMacetasJSON.EscribirMaceta();

//        System.out.println(jardinesLeidos);

        for(Object macetaOjeto : macetasLeidos){
            JSONObject macetaJSON = (JSONObject) macetaOjeto;
            macetasEscritos.add(LeerMacetasJSON.parseUser(macetaJSON));
        }

//        System.out.println(usuariosLeidos);
//        System.out.println(usuariosCargados);
        System.out.println(macetasEscritos);
    }
    public static void editarMacetas() {

        macetasLeidos.clear();
        macetasEditados.clear();
        EditarMacetasJSON.EditarMacetas();

        for (Object macetaOjeto : macetasLeidos) {
            JSONObject macetaJSON = (JSONObject) macetaOjeto;
            macetasEditados.add(LeerMacetasJSON.parseUser(macetaJSON));
        }

        System.out.println(macetasEditados);
    }
    public static void eliminarMacetas () {
//
        macetasLeidos.clear();
        macetasEliminados.clear();
        EliminarMacetasJSON.EliminarMacetas();

        for (Object macetaOjeto : macetasLeidos) {
            JSONObject macetaJSON = (JSONObject) macetaOjeto;
            macetasEliminados.add(LeerMacetasJSON.parseUser(macetaJSON));
        }

        System.out.println(macetasEliminados);

    }
    public static void crudSustratos() {

        String option;

        while (true) {
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver Sustratos");
            System.out.println("2. Crear Sustratos");
            System.out.println("3. Editar Sustratos");
            System.out.println("4. Eliminar Sustratos");
            System.out.println("0. Retornar al menú anterior");
            System.out.println();

            option = input.next();
            if (option.equals("1")) {
                verSustratos();
            } else if (option.equals("2")) {
                crearSustratos();
            } else if (option.equals("3")) {
//                editarJardines();
            } else if (option.equals("4")) {
//                eliminarJardines();
            } else if (option.equals("0")) {
                break;
            }

        }
    }



    public static void verSustratos(){

//        ArrayList <Jardin> jardinesLeidos = LeerJardinesJSON.leerJardines();

        for(Object sustratoObjeto : sustratosLeidos){
            JSONObject sustratoJSON = (JSONObject) sustratoObjeto;
            sustratosCargados.add(LeerSustratoJSON.parseUser(sustratoJSON));
        }

        System.out.println(sustratosCargados);

        sustratosLeidos.clear();
    }



    public static void crearSustratos() {

        sustratosLeidos.clear();
        sustratosEscritos.clear();

//      Escribe el jardin nuevo en el archivo json
        EscribirSustratoJSON.EscribirSustrato();

//        System.out.println(jardinesLeidos);

        for(Object sustratoObjeto : sustratosLeidos){
            JSONObject sustratoJSON = (JSONObject) sustratoObjeto;
            sustratosEscritos.add(LeerSustratoJSON.parseUser(sustratoJSON));
        }

//        System.out.println(usuariosLeidos);
//        System.out.println(usuariosCargados);
        System.out.println(sustratosEscritos);
    }
    public static void crudPlantas() {

        String option;

        while (true) {
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver plantas");
            System.out.println("2. Crear plantas");
            System.out.println("3. Editar plantas");
            System.out.println("4. Eliminar plantas");
            System.out.println("0. Retornar al menú anterior");
            System.out.println();

            option = input.next();
            if (option.equals("1")) {
                verPlantas();
            } else if (option.equals("2")) {
                crearPlantas();
            } else if (option.equals("3")) {
//                editarJardines();
            } else if (option.equals("4")) {
//                eliminarJardines();
            } else if (option.equals("0")) {
                break;
            }

        }
    }



    public static void verPlantas(){

//        ArrayList <Jardin> jardinesLeidos = LeerJardinesJSON.leerJardines();

        for(Object plantaObjeto : plantasLeidos){
            JSONObject plantaJSON = (JSONObject) plantaObjeto;
            plantasCargados.add(LeerPlantaJSON.parseUser(plantaJSON));
        }

        System.out.println(plantasCargados);

        plantasLeidos.clear();
    }



    public static void crearPlantas() {

        plantasLeidos.clear();
        plantasEscritos.clear();

//      Escribe el jardin nuevo en el archivo json
        EscribirPlantaJSON.EscribirPlanta();

//        System.out.println(jardinesLeidos);

        for(Object plantaObjeto : plantasLeidos){
            JSONObject plantaJSON = (JSONObject) plantaObjeto;
            plantasEscritos.add(LeerPlantaJSON.parseUser(plantaJSON));
        }

//        System.out.println(usuariosLeidos);
//        System.out.println(usuariosCargados);
        System.out.println(plantasEscritos);
    }
    public static void crudAbonos() {

        String option;

        while (true) {
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver abono");
            System.out.println("2. Crear abono");
            System.out.println("3. Editar abonos");
            System.out.println("4. Eliminar abonos");
            System.out.println("0. Retornar al menú anterior");
            System.out.println();

            option = input.next();
            if (option.equals("1")) {
                verAbonos();
            } else if (option.equals("2")) {
                crearAbonos();
            } else if (option.equals("3")) {
//                editarJardines();
            } else if (option.equals("4")) {
                eliminarAbonos();
            } else if (option.equals("0")) {
                break;
            }

        }
    }



    public static void verAbonos(){

//        ArrayList <Jardin> jardinesLeidos = LeerJardinesJSON.leerJardines();

        for(Object abonoObjeto : abonosLeidos){
            JSONObject abonoJSON = (JSONObject) abonoObjeto;
            abonosCargados.add(LeerAbonosJSON.parseUser(abonoJSON));
        }

        System.out.println(abonosCargados);

        abonosLeidos.clear();
    }



    public static void crearAbonos() {

        abonosLeidos.clear();
        abonosEscritos.clear();

//      Escribe el jardin nuevo en el archivo json
        EscribirAbonosJSON.EscribirAbono();

//        System.out.println(jardinesLeidos);

        for(Object abonoObjeto : abonosLeidos){
            JSONObject abonoJSON = (JSONObject) abonoObjeto;
            abonosEscritos.add(LeerAbonosJSON.parseUser(abonoJSON));
        }

//        System.out.println(usuariosLeidos);
//        System.out.println(usuariosCargados);
        System.out.println(abonosEscritos);
    }
    public static void eliminarAbonos () {
//
        abonosLeidos.clear();
        abonosEliminados.clear();
        EliminarAbonosJSON.EliminarAbonos();

        for (Object abonoObjeto : abonosLeidos) {
            JSONObject abonoJSON = (JSONObject) abonoObjeto;
            abonosEliminados.add(LeerAbonosJSON.parseUser(abonoJSON));
        }

        System.out.println(abonosEliminados);

    }
    public static void crudPlagas() {

        String option;

        while (true) {
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver plaga");
            System.out.println("2. Crear plaga");
            System.out.println("3. Editar plaga");
            System.out.println("4. Eliminar plaga");
            System.out.println("0. Retornar al menú anterior");
            System.out.println();

            option = input.next();
            if (option.equals("1")) {
                verPlagas();
            } else if (option.equals("2")) {
                crearPlagas();
            } else if (option.equals("3")) {
//                editarJardines();
            } else if (option.equals("4")) {
//                eliminarJardines();
            } else if (option.equals("0")) {
                break;
            }

        }
    }



    public static void verPlagas(){

//        ArrayList <Jardin> jardinesLeidos = LeerJardinesJSON.leerJardines();

        for(Object plagaObjeto : plagasLeidos){
            JSONObject plagaJSON = (JSONObject) plagaObjeto;
            plagasCargados.add(LeerPlagaJSON.parseUser(plagaJSON));
        }

        System.out.println(plagasCargados);

        plagasLeidos.clear();
    }



    public static void crearPlagas() {

        plagasLeidos.clear();
        plagasEscritos.clear();

//      Escribe el jardin nuevo en el archivo json
        EscribirPlagaJSON.EscribirPlaga();

//        System.out.println(jardinesLeidos);

        for(Object plagaObjeto : plagasLeidos){
            JSONObject plagaJSON = (JSONObject) plagaObjeto;
            plagasEscritos.add(LeerPlagaJSON.parseUser(plagaJSON));
        }

//        System.out.println(usuariosLeidos);
//        System.out.println(usuariosCargados);
        System.out.println(plagasEscritos);
    }
    public static void crudRemedios() {

        String option;

        while (true) {
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver remedio");
            System.out.println("2. Crear remedio");
            System.out.println("3. Editar remedio");
            System.out.println("4. Eliminar remedio");
            System.out.println("0. Retornar al menú anterior");
            System.out.println();

            option = input.next();
            if (option.equals("1")) {
                verRemedios();
            } else if (option.equals("2")) {
                crearRemedios();
            } else if (option.equals("3")) {
//                editarJardines();
            } else if (option.equals("4")) {
                eliminarRemedios();
            } else if (option.equals("0")) {
                break;
            }

        }
    }



    public static void verRemedios(){

//        ArrayList <Jardin> jardinesLeidos = LeerJardinesJSON.leerJardines();

        for(Object remedioObjeto : remediosLeidos){
            JSONObject remedioJSON = (JSONObject) remedioObjeto;
            remediosCargados.add(LeerRemediosJSON.parseUser(remedioJSON));
        }

        System.out.println(remediosCargados);

        remediosLeidos.clear();
    }



    public static void crearRemedios() {

        remediosLeidos.clear();
        remediosEscritos.clear();

//      Escribe el jardin nuevo en el archivo json
        EscribirRemediosJSON.EscribirRemedio();

//        System.out.println(jardinesLeidos);

        for(Object remedioObjeto : remediosLeidos){
            JSONObject remedioJSON = (JSONObject) remedioObjeto;
            remediosEscritos.add(LeerRemediosJSON.parseUser(remedioJSON));
        }

//        System.out.println(usuariosLeidos);
//        System.out.println(usuariosCargados);
        System.out.println(remediosEscritos);
    }
    public static void eliminarRemedios () {
//
        remediosLeidos.clear();
        remediosEliminados.clear();
        EliminarRemediosJSON.EliminarRemedios();

        for (Object remedioObjeto : remediosLeidos) {
            JSONObject remedioJSON = (JSONObject) remedioObjeto;
            remediosEliminados.add(LeerRemediosJSON.parseUser(remedioJSON));
        }

        System.out.println(remediosEliminados);

    }
}
