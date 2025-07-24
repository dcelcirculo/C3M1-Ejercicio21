import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        var exit = false;

        do {
            System.out.println("");
            System.out.println("--- Conversor de kilometros y millas ---");
            System.out.println("Seleccione una opción: ");
            System.out.println("");
            var option = pedirDatos(entrada, """
                    1. Millas a Kilometros
                    2. Kilometros a millas
                    0. Salir
                    """);

            switch (option) {
                case 1:
                    milesToKm(entrada);
                    break;
                case 2:
                    kmTomiles(entrada);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida, por favor inténtelo de nuevo.");
            }

        } while (!exit);
        System.out.println("--- Hasta pronto! ---");
    }

    public static void milesToKm(Scanner entrada) {
        System.out.println("Ingrese la cantidad de millas a convertir: ");
        double number = entrada.nextDouble();
        final double KILOMETER = 1.60934;

        var milesToKm = number * KILOMETER;
        System.out.printf("%.2f millas son %.2f Kilometros.", number, milesToKm);
    }

    public static void kmTomiles(Scanner entrada) {
        System.out.println("Ingrese la cantidad de kilometros a convertir: ");
        double number = entrada.nextDouble();
        final double MILES = 0.621371;

        var kmTomiles = number * MILES;
        System.out.printf("%.2f Kilometros. son %.2f millas", number, kmTomiles);
    }

    public static int pedirDatos(Scanner entrada, String mensaje) {

        int number = 0;
        boolean validator = false;
        do {
            System.out.print(mensaje);
            if (entrada.hasNextInt()) {
                number = entrada.nextInt();
                validator = true;
            } else {
                System.out.println("Entrada inválida. Inténtelo de nuevo.");
                entrada.next();
            }
        } while (!validator);

        return number;
    }
}
