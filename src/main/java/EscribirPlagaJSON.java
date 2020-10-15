import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirPlagaJSON {

    public static String ruta = "src/main/resources/database/";
    public static Scanner input = new Scanner(System.in);

    public static void EscribirPlaga() {

        System.out.println("Ingrese los datos de la nueva plaga:");

        System.out.println("Ingrese la referencia:");
        int Referencia = input.nextInt();

        System.out.println("Ingrese el nombre del organismo:");
        String Organismo = input.next();

        System.out.println("Ingrese la cantidad del organismo:");
        int Cantidad  = input.nextInt();

        System.out.println("ingrese el Porcentaje de abono:");
        String Remedio = input.next();

        JSONObject PlagaDetails = new JSONObject();
        PlagaDetails.put("Referencia", Referencia);
        PlagaDetails.put("Organismo", Organismo);
        PlagaDetails.put("Cantidad", Cantidad);
        PlagaDetails.put("Remedio", Remedio);

        JSONArray plagaList = LeerPlagaJSON.LeerPlaga();
        plagaList.add(PlagaDetails);

        try (FileWriter file = new FileWriter(ruta + "Sustratos.json")) {
            file.write(plagaList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

