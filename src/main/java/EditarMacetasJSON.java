import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EditarMacetasJSON {

    public static Scanner input = new Scanner(System.in);
    public static String ruta = "src/main/resources/database/";
    public static JSONArray macetasEditar = LeerMacetasJSON.leerMacetas();

    public static void EditarMacetas() {

        System.out.println(macetasEditar);

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("Seleccionar por referencia de la maceta:");
        System.out.println();

        System.out.println("Lista de las referencias de macetas:");
        for (Object macetaObjeto : macetasEditar) {
            JSONObject macetaJSON = (JSONObject) macetaObjeto;
            int referencia = (int) macetaJSON.get("referencia");
            System.out.println(referencia);
        }

        //Solicitud de datos de la maceta  a editar
        System.out.println("Ingrese la referencia de la maceta a editar:");
        int referenciaEditar = input.nextInt();



        System.out.println("Ingrese los nuevos datos de la maceta:");
//        for (Jardin macetaEditar : macetasEditar) {
        for (Object macetaObjeto : macetasEditar) {
            JSONObject macetaJSON = (JSONObject) macetaObjeto;
            int referencia = (int) macetaJSON.get("referencia");
            String material = ((String) macetaJSON.get("material"));
//            System.out.println("material: " + material);
            int diametro = (int) macetaJSON.get("diametro");
//            System.out.println("diametro: " + diametro);
            int profundidad = ((int) macetaJSON.get("profundidad"));
//            System.out.println("profundidad: " + profundidad);
            int cantidad = ((int) macetaJSON.get("cantidad"));
//            System.out.println("cantidad: " + cantidad);
            int costoUnitario = ((int) macetaJSON.get("costoUnitario"));
//            System.out.println("costo: " + costo);

            if (referenciaEditar == (referencia)) {
                System.out.println("La actual referencia de la maceta es:");
                System.out.println("referencia: " + referencia);
//                System.out.println(macetaEditar.referencia);
                System.out.println("Ingrese la nueva referencia de la maceta u oprima enter para continuar:");
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
                long referenciaNueva = editarOContinuarLng(referencia);
                System.out.println(referenciaNueva);

                System.out.println("El material actual de la maceta es:");
                System.out.println("material: " + material);
                System.out.println("Ingrese el nuevo material de la maceta y oprima enter para continuar:");
                String materialNuevo = editarOContinuarStr(material);
                System.out.println(materialNuevo);

                System.out.println("El diametro actual de la maceta es:");
                System.out.println("diametro: " + diametro);
                System.out.println("Ingrese el nuevo diametro de la maceta y oprima enter para continuar:");
                long diametroNuevo = editarOContinuarLng(diametro);
                System.out.println(diametroNuevo);

                System.out.println("La profundidad actual de la maceta es:");
                System.out.println("profundiad: " + profundidad);
                System.out.println("Ingrese la nueva profundidad de la maceta y oprima enter para continuar:");
                long profundidadNueva = editarOContinuarLng(profundidad);
                System.out.println(profundidadNueva);

                System.out.println("la cantidad actual de macetas es:");
                System.out.println("cantidad: " + cantidad);
                System.out.println("Ingrese la nueva cantidad de macetas y oprima enter para continuar:");
                long cantidadNueva = editarOContinuarLng(cantidad);
                System.out.println(cantidadNueva);

                System.out.println("el costo unitario actual de macetas es:");
                System.out.println("costoUnitario: " + costoUnitario);
                System.out.println("Ingrese el nuevo costo unitario de las macetas y oprima enter para continuar:");
                long costoUnitarioNuevo = editarOContinuarLng(costoUnitario);
                System.out.println(costoUnitarioNuevo);

                Maceta macetaEditada = new Maceta(referenciaNueva, materialNuevo,diametroNuevo, profundidadNueva, cantidadNueva, costoUnitarioNuevo);
                System.out.println(macetaEditada);

                System.out.println("¿Desea guardar los cambios? Y:sí N:no");
                String in = input.next();
                if (in.equals("Y")) {
                    EscribirMacetaArchivo(referenciaNueva, materialNuevo,diametroNuevo, profundidadNueva, cantidadNueva, costoUnitarioNuevo);
                    return;
                } else if (in.equals("N")) {
                    return;
                }
            }

        }
    }


    public static void EscribirMacetaArchivo(long referencia, String material, long diametro, long profundidad, long cantidad, long costoUnitario) {

        //Convirtiendo a objeto Usuario
        JSONObject userDetails = new JSONObject();
        userDetails.put("referencia", referencia);
        userDetails.put("material", material);
        userDetails.put("diametro", diametro);
        userDetails.put("profundidad", profundidad);
        userDetails.put("cantidadad", cantidad);
        userDetails.put("costoUnitario", costoUnitario);

        //Add employee to list
//        JSONArray jardinesList = LeerJardinesJSON.leerJardines();
        JSONArray macetasList = macetasEditar;

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

        for (int i = 0; i < macetasList.size(); i++) {
            JSONObject macetaJSON = (JSONObject) macetasList.get(i);
            int referenciaNuevai = (int) macetaJSON.get("referencia");
            if (referenciaEditar == (referenciaNuevai)) {
                macetasList.remove(i);
//                return;
            }
        }

//        System.out.println(jardinesList);

        macetasList.add(userDetails);

//        System.out.println(jardinesList);


        //Write JSON file
//        try (FileWriter file = new FileWriter(ruta + "usuarios.json", true)) {
        try (FileWriter file = new FileWriter(ruta + "macetas.json")) {

            file.write(macetasList.toJSONString());
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