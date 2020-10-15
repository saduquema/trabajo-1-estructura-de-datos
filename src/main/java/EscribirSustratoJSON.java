import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirSustratoJSON {

    public static String ruta = "src/main/resources/database/";
    public static Scanner input = new Scanner(System.in);

    public static void EscribirSustrato() {

        System.out.println("Ingrese los datos del nuevo sustrato:");

        System.out.println("Ingrese la referencia:");
        long Referencia = input.nextLong();

        System.out.println("Ingrese el porcentaje de tierra:");
        long PorcentajeDeTierra = input.nextLong();

        System.out.println("Ingrese el Porcentaje de minerales:");
        long PorcentajeDeMinerales = input.nextLong();

        System.out.println("ingrese el Porcentaje de abono:");
        long PorcentajeDeAbono = input.nextLong();

        System.out.println("ingrese el Costo:");
        long Costo = input.nextLong();

        JSONObject SustratoDetails = new JSONObject();
        SustratoDetails.put("Referencia", Referencia);
        SustratoDetails.put("PorcentajeDeTierra", PorcentajeDeTierra);
        SustratoDetails.put("PorcentajeDeMinerales", PorcentajeDeMinerales);
        SustratoDetails.put("PorcentajeDeAbono", PorcentajeDeAbono);
        SustratoDetails.put("Costo", Costo);

        JSONArray sustratoList = LeerSustratoJSON.LeerSustrato();
        sustratoList.add(SustratoDetails);

        try (FileWriter file = new FileWriter(ruta + "Sustratos.json")) {
            file.write(sustratoList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



