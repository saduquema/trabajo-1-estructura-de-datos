import java.util.Scanner;

public class SistemaJardines {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        //Menú inicial - usuario
        String option;

        while (true) {
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Buenas, bienvenido al sistema de diseño de jardines");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ingresar");
            System.out.println("2. Registrarse");
            System.out.println("0. Salir");
            System.out.println();

            option = input.next();
            if (option.equals("1")) {
//            ingresarUsuario();
            } else if (option.equals("2")) {
//            registrarUsuario();
            } else if (option.equals("0")) {
                break;
            }
        }
    }

    public static void ingresarUsuario() {
//
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
