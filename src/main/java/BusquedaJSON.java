import java.util.Scanner;
public class BusquedaJSON {
    public static Scanner input = new Scanner(System.in);
    public static void BusquedaJSON{
        String option;
        label:
        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("Por favor, selecione la clase que desea buscar: \n");
            System.out.println("1. Zoologico.");
            System.out.println("2. Bioma.");
            System.out.println("3. Habitat.");
            System.out.println("4. Animal.");
            System.out.println("5. Tecnico.");
            System.out.println("6. Profesional.");
            System.out.println("7. ZooAmigo.");
            System.out.println("0. Regresar a Menu Principal.");
            option = input.next();
            System.out.println();
            switch (option) {
                case "1":
                    if (zoologicos.size() == 0) {
                        System.out.println("No se encuentran zoologicos registrados");
                    } else {
                        busquedaZoologico();
                    }
                    break;
                case "2":
                    if (biomas.size() == 0) {
                        System.out.println("No se encuentran biomas registrados");
                    } else {
                        busquedaBioma();
                    }
                    break;
                case "3":
                    if (habitats.size() == 0) {
                        System.out.println("No se encuentran habitats registrados");
                    } else {
                        busquedaHabitat();
                    }
                    break;
                case "4":
                    if (animales.size() == 0) {
                        System.out.println("No se encuentran animales registrados");
                    } else {
                        busquedaAnimal();
                    }
                    break;
                case "5":
                    if (tecnicos.size() == 0) {
                        System.out.println("No se encuentran tecnicos registrados");
                    } else {
                        busquedaTecnico();
                    }
                    break;
                case "6":
                    if (profesionales.size() == 0) {
                        System.out.println("No se encuentran profesionales registrados");
                    } else {
                        busquedaProfesional();
                    }
                    break;
                case "7":
                    if (zooAmigos.size() == 0) {
                        System.out.println("No se encuentran ZooAmigos registrados");
                    } else {
                        busquedaZooamigo();
                    }
                    break;
                case "0":
                    break label;
            }
            System.out.println("----------------------------------");
        }
    }
}
