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
        System.out.println("Seleccionar la referencia de una maceta:");
        System.out.println();

        System.out.println("Lista de refenrencias de macetas:");
        for (Object macetaObjeto : macetasEditar) {
            JSONObject macetaJSON = (JSONObject) macetaObjeto;
            long referencia = (long) macetaJSON.get("referencia");
            System.out.println(referencia);
        }

        //Solicitud de datos del jardin a editar
        System.out.println("Ingrese la referenca de maceta a editar:");
        long referenciaEditar = input.nextLong();

        System.out.println("Ingrese los nuevos datos de la maceta:");
//        for (Jardin jardinEditar : jardinesEditar) {
        for (Object macetaObjeto : macetasEditar) {
            JSONObject macetaJSON = (JSONObject) macetaObjeto;
            long referencia = (long) macetaJSON.get("referencia");
            String material = ((String) macetaJSON.get("material"));
//            System.out.println("area: " + area);
            long diametro = (long) macetaJSON.get("diametro");
//            System.out.println("ambiente: " + ambiente);
            long profundidad = ((long) macetaJSON.get("profundidad"));
//            System.out.println("temperaturaPromedio: " + temperaturaPromedio);
            long cantidad = ((long) macetaJSON.get("cantidad"));
//            System.out.println("iluminacion: " + iluminacion);
            long costoUnitario =(long) macetaJSON.get("costoUnitario");

            if (referenciaEditar==(referencia)) {
                System.out.println("La actual referencia de la  maceta es:");
                System.out.println("referencia: " + referencia);
//                System.out.println(jardinEditar.nombreDueno);
                System.out.println("Ingrese la nueva referencia de la maceta u oprima enter para continuar:");
                input.nextLong();
//                input.nextLine();
//                String in = input.nextLine();
//                String nombreDuenoNuevo = "";
//                if (in.equals("")) {
//                    continuar = true;
//                } else {
//                    nombreDuenoNuevo = in;
//                }
//                System.out.println(nombreDuenoNuevo);
                long referenciaNuevo = editarOContinuarLng(referencia);
                System.out.println(referenciaNuevo);

                System.out.println("El material actual de la maceta es:");
                System.out.println("material: " + material);
                System.out.println("Ingrese el nuevo material de la maceta u oprima enter para continuar:");
                String materialNueva = editarOContinuarStr(material);
                System.out.println(materialNueva);

                System.out.println("El diametro actual de la maceta es:");
                System.out.println("diametro: " + diametro);
                System.out.println("Ingrese el nuevo diametro de la maceta u oprima enter para continuar:");
                long diametroNuevo = editarOContinuarLng(diametro);
                System.out.println(diametroNuevo);

                System.out.println("La profundidad actual de la maceta es:");
                System.out.println("profundidad: " + profundidad);
                System.out.println("Ingrese la nueva profundidad de la maceta u oprima enter para continuar:");
                long profundidadNueva = editarOContinuarLng(profundidad);
                System.out.println(profundidadNueva);

                System.out.println("La cantidad actual de macetas es:");
                System.out.println("cantidad: " + cantidad);
                System.out.println("Ingrese la nueva cantidad de macetas u oprima enter para continuar:");
                long cantidadNueva = editarOContinuarLng(cantidad);
                System.out.println(cantidadNueva);

                System.out.println("el costo unitario actual de macetas es:");
                System.out.println("costoUnitario: " + costoUnitario);
                System.out.println("Ingrese el nuevo costo unitario de macetas u oprima enter para continuar:");
                long costoUnitarioNueva = editarOContinuarLng(costoUnitario);
                System.out.println(costoUnitarioNueva);

                Maceta macetaEditado = new Maceta(referenciaNuevo, materialNueva, diametroNuevo, profundidadNueva, cantidadNueva,costoUnitarioNueva);
                System.out.println(macetaEditado);

                System.out.println("¿Desea guardar los cambios? Y:sí N:no");
                String in = input.next();
                if (in.equals("Y")) {
                    EscribirMacetasArchivo(referenciaNuevo, materialNueva, diametroNuevo, profundidadNueva, cantidadNueva,costoUnitarioNueva);
                    return;
                } else if (in.equals("N")) {
                    return;
                }
            }

        }
    }

    public static void EscribirMacetasArchivo(long referencia,String material,long diametro,long profundidad,long cantidad,long costoUnitario) {

        //Convirtiendo a objeto Usuario
        JSONObject userDetails = new JSONObject();
        userDetails.put("referencia", referencia);
        userDetails.put("material", material);
        userDetails.put("diametro", diametro);
        userDetails.put("profundidad", profundidad);
        userDetails.put("cantidad", cantidad);
        userDetails.put("costoUnitario",costoUnitario);
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
            long referenciai = (long) macetaJSON.get("referencia");
            if (referencia==(referenciai)) {
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
