import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int respuesta;
        ArrayList<String> listaDeTareas = new ArrayList<>();

        do {
            // Menú principal
            System.out.println("Seleccione una opción");
            System.out.println("1. Ver si un número es par o impar");
            System.out.println("2. Ver si un número es primo o no");
            System.out.println("3. Adivinar un número (1-10)");
            System.out.println("4. Lista de tareas (CRUD)");
            System.out.println("5. Conversor de temperaturas F -> C");
            System.out.println("6. Conexión a DB");
            System.out.println("7. Salir");
            System.out.print("Ingrese su opción: ");

            // Manejo de la entrada del usuario
            try {
                respuesta = scanner.nextInt();
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 7.");
                scanner.nextLine();
                respuesta = 0;
            }

            switch (respuesta) {
                case 1:
                    verParImpar(scanner);
                    break;
                case 2:
                    verSiEsPrimo(scanner);
                    break;
                case 3:
                    adivinarNumero(scanner);
                    break;
                case 4:
                    crudTareas(scanner, listaDeTareas);
                    break;
                case 5:
                    convertirTemperatura(scanner);
                    break;
                case 6:

                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    if (respuesta != 0) {
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    }
            }
        } while (respuesta != 7);

        scanner.close();
    }

    // Metodos para cada opción del menu

    private static void verParImpar(Scanner scanner) {
        System.out.print("Ingrese un número para ver si es par o no: ");
        int n = scanner.nextInt();
        if (n % 2 == 0) {
            System.out.println("El número " + n + " es par.");
        } else {
            System.out.println("El número " + n + " es impar.");
        }
        scanner.nextLine();
    }

    private static void verSiEsPrimo(Scanner scanner) {
        System.out.print("Ingrese un número para ver si es primo o no: ");
        int num = scanner.nextInt();
        boolean primo = true;
        if (num <= 1) {
            primo = false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    primo = false;
                    break;
                }
            }
        }
        if (primo) {
            System.out.println("El número " + num + " es primo.");
        } else {
            System.out.println("El número " + num + " no es primo.");
        }
        scanner.nextLine();
    }

    private static void adivinarNumero(Scanner scanner) {
        Random random = new Random();
        int numeroSecreto = random.nextInt(10) + 1;
        int intento;
        System.out.println("La máquina ha escogido un número del 1 al 10. ¡Intenta adivinarlo!");

        do {
            System.out.print("Ingrese su intento: ");
            intento = scanner.nextInt();
            if (intento != numeroSecreto) {
                System.out.println("Incorrecto. Vuelve a intentarlo.");
            }
        } while (intento != numeroSecreto);

        System.out.println("¡Felicidades! Has adivinado el número: " + numeroSecreto);
        scanner.nextLine();
    }

    private static void crudTareas(Scanner scanner, ArrayList<String> lista) {
        System.out.println("Gestor de Tareas");
        System.out.println("1. Ver tareas");
        System.out.println("2. Agregar tarea");
        System.out.println("3. Eliminar tarea");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.println("Tus Tareas");
                if (lista.isEmpty()) {
                    System.out.println("No hay tareas pendientes.");
                } else {
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println((i + 1) + ". " + lista.get(i));
                    }
                }
                break;
            case 2:
                System.out.print("Ingrese la nueva tarea: ");
                String nuevaTarea = scanner.nextLine();
                lista.add(nuevaTarea);
                System.out.println("Tarea agregada: " + nuevaTarea);
                break;
            case 3:
                System.out.print("Ingrese el número de la tarea a eliminar: ");
                int indice = scanner.nextInt() - 1;
                if (indice >= 0 && indice < lista.size()) {
                    String tareaEliminada = lista.remove(indice);
                    System.out.println("Tarea eliminada: " + tareaEliminada);
                } else {
                    System.out.println("Índice no válido.");
                }
                scanner.nextLine();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void convertirTemperatura(Scanner scanner) {
        System.out.print("Ingrese la temperatura en grados Fahrenheit (F): ");
        double fahrenheit = scanner.nextDouble();
        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.printf("Su temperatura %.2f F es %.2f C.\n", fahrenheit, celsius);
        scanner.nextLine();
    }
}
