import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EditarJardinesJSON {

    public static Scanner input = new Scanner(System.in);
    public static String ruta = "src/main/resources/database/";
    public static JSONArray jardinesEditar = LeerJardinesJSON.leerJardines();

    public static void EditarJardines() {

        System.out.println(jardinesEditar);

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("Seleccionar por nombre del dueño/jardín:");
        System.out.println();

        System.out.println("Lista de nombres dueño/jardín:");
        for (Object jardinObjeto : jardinesEditar) {
            JSONObject jardinJSON = (JSONObject) jardinObjeto;
            String nombreDueno = (String) jardinJSON.get("nombreDueno");
            System.out.println(nombreDueno);
        }

        //Solicitud de datos del jardin a editar
        System.out.println("Ingrese el nombre dueño/jardín a editar:");
        String nombreDuenoEditar = input.next();


        System.out.println("Ingrese los nuevos datos del jardín:");
//        for (Jardin jardinEditar : jardinesEditar) {
        for (Object jardinObjeto : jardinesEditar) {
            JSONObject jardinJSON = (JSONObject) jardinObjeto;
            String nombreDueno = (String) jardinJSON.get("nombreDueno");
            long area = ((long) jardinJSON.get("area"));
//            System.out.println("area: " + area);
            String ambiente = (String) jardinJSON.get("ambiente");
//            System.out.println("ambiente: " + ambiente);
            long temperaturaPromedio = ((long) jardinJSON.get("temperaturaPromedio"));
//            System.out.println("temperaturaPromedio: " + temperaturaPromedio);
            String iluminacion = ((String) jardinJSON.get("iluminacion"));
//            System.out.println("iluminacion: " + iluminacion);

            if (nombreDuenoEditar.equals(nombreDueno)) {
                System.out.println("El actual nombre del dueño del jardín es:");
                System.out.println("nombreDueno: " + nombreDueno);
//                System.out.println(jardinEditar.nombreDueno);
                System.out.println("Ingrese el nuevo nombre del dueño del jardín u oprima enter para continuar:");
                input.nextLine();
//                input.nextLine();
//                String in = input.nextLine();
//                String nombreDuenoNuevo = "";
//                if (in.equals("")) {
//                    continuar = true;
//                } else {
//                    nombreDuenoNuevo = in;
//                }
//                System.out.println(nombreDuenoNuevo);
                String nombreDuenoNuevo = editarOContinuarStr(nombreDueno);
                System.out.println(nombreDuenoNuevo);

                System.out.println("El area actual del jardín es:");
                System.out.println("area: " + area);
                System.out.println("Ingrese la nueva area del jardín en m2 u oprima enter para continuar:");
                long areaNueva = editarOContinuarLng(area);
                System.out.println(areaNueva);

                System.out.println("El ambiente actual del jardín es:");
                System.out.println("ambiente: " + ambiente);
                System.out.println("Ingrese el nuevo ambiente del jardín (húmedo, seco, parcial/.) u oprima enter para continuar:");
                String ambienteNuevo = editarOContinuarStr(ambiente);
                System.out.println(ambienteNuevo);

                System.out.println("La temperatura promedio actual del jardín es:");
                System.out.println("temperaturaPromedio: " + temperaturaPromedio);
                System.out.println("Ingrese la nueva temperatura promedio del jardín en °C u oprima enter para continuar:");
                long temperaturaPromedioNueva = editarOContinuarLng(temperaturaPromedio);
                System.out.println(temperaturaPromedioNueva);

                System.out.println("La iluminacion actual del jardín es:");
                System.out.println("iluminacion: " + iluminacion);
                System.out.println("Ingrese la nueva iluminacion del jardín (soleado, iluminado, parcial/. u oprima enter para continuar:");
                String iluminacionNueva = editarOContinuarStr(iluminacion);
                System.out.println(iluminacionNueva);

                Jardin jardinEditado = new Jardin(nombreDuenoNuevo, areaNueva, ambienteNuevo, temperaturaPromedioNueva, iluminacionNueva);
                System.out.println(jardinEditado);

                System.out.println("¿Desea guardar los cambios? Y:sí N:no");
                String in = input.next();
                if (in.equals("Y")) {
                    EscribirJardinArchivo(nombreDuenoNuevo, areaNueva, ambienteNuevo, temperaturaPromedioNueva, iluminacionNueva, nombreDuenoEditar);
                    return;
                } else if (in.equals("N")) {
                    return;
                }
            }

        }
    }

    public static void EscribirJardinArchivo(String nombreDueno, long area, String ambiente, long temperaturaPromedio, String iluminacion, String nombreDuenoEditar) {

        //Convirtiendo a objeto Usuario
        JSONObject userDetails = new JSONObject();
        userDetails.put("nombreDueno", nombreDueno);
        userDetails.put("area", area);
        userDetails.put("ambiente", ambiente);
        userDetails.put("temperaturaPromedio", temperaturaPromedio);
        userDetails.put("iluminacion", iluminacion);

        //Add employee to list
//        JSONArray jardinesList = LeerJardinesJSON.leerJardines();
        JSONArray jardinesList = jardinesEditar;

//      Removiendo por dueño en la lista de jardines
//        for (Object jardinObjeto : jardinesList) {
//            JSONObject jardinJSON = (JSONObject) jardinObjeto;
//            String nombreDuenoi = (String) jardinJSON.get("nombreDueno");
//            if (nombreDuenoEditar.equals(nombreDuenoi)) {
//                System.out.println("hello4");
//                jardinJSON.remove(nombreDuenoEditar);
//                return;
//            }
//        }

        for (int i = 0; i < jardinesList.size(); i++) {
            JSONObject jardinJSON = (JSONObject) jardinesList.get(i);
            String nombreDuenoi = (String) jardinJSON.get("nombreDueno");
            if (nombreDuenoEditar.equals(nombreDuenoi)) {
                jardinesList.remove(i);
//                return;
            }
        }

//        System.out.println(jardinesList);

        jardinesList.add(userDetails);

//        System.out.println(jardinesList);


        //Write JSON file
//        try (FileWriter file = new FileWriter(ruta + "usuarios.json", true)) {
        try (FileWriter file = new FileWriter(ruta + "jardines.json")) {

            file.write(jardinesList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String editarOContinuarStr(String atributo) {
        String in = input.nextLine();
        String atributoNuevo = "";
        if (in.equals("")) {
            atributoNuevo = atributo;
        } else {
            atributoNuevo = in;
        }
        return atributoNuevo;
    }

    public static long editarOContinuarLng(long atributo) {
        String in = input.nextLine();
        long atributoNuevo = 0;
        if (in.equals("")) {
            atributoNuevo = atributo;
        } else {
            atributoNuevo = Long.parseLong(in);
        }
        return atributoNuevo;
    }

}

