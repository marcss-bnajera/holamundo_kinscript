import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Menu principal
        System.out.println("Seleccione que quiere realizar:");
        System.out.println("1. Ver que un número sea par o impar");
        System.out.println("2. Ver si un número es primo o no");
        System.out.println("3. Adivinar un número dentro de 1-10");
        System.out.println("4. Lista de tareas a completar - CRUD");
        System.out.println("5. Conversor de temperaturas F -> C");
        System.out.println("6. conexion a DB para una agenda de contactos");
        System.out.println("7. Salir...");

        int respuesta = scanner.nextInt();

        do{
            switch (respuesta) {
                case 1:

                    System.out.println("Ingrese un número para ver si es par o no:");
                    int n = scanner.nextInt();

                    if (n % 2 == 0) {
                        System.out.println("El número " +n+ " es par");
                    }else {
                        System.out.println("El número " +n+ " es impar");
                    }

                    break;
                case 2:
                    System.out.println("Ingrese un número para ver si es primo o no");
                    int num = scanner.nextInt();

                    boolean primo = true;
                    for(int i = 2; i < num; i++) {
                        if (num % i == 0) {
                            primo = false;
                            break;
                        }
                    }
                    if (primo) {

                        System.out.println("El número es primo");
                    }else{
                        System.out.println("El número no es primo");
                    }

                    break;
                case 3:

                    Random random = new Random();

                    int nume= random.nextInt(0, 11);

                    System.out.println("La maquina a escogido un número...");
                    System.out.println("Ingrese un número para intentar adivinar el número de la maquina");

                    boolean intentos = true;
                    do {
                        int a = scanner.nextInt();
                        if (a == nume) {
                            System.out.println("A adivinado el número :)");
                            intentos = true;
                            break;
                        }else {
                            System.out.println("Vuelvelo a intentar");
                            intentos = false;
                        }
                    }while(intentos =! false);
                    break;
                case 4:
                    ArrayList<String> lista = new ArrayList();

                    System.out.println("Seleccione una opcion");
                    System.out.println("1. Agregar una tarea");
                    System.out.println("2. Eliminar una tarea");
                    System.out.println("3. Editar una tarea");
                    int opcion = scanner.nextInt();
                    scanner.nextLine();

                    if (opcion == 1) {
                        System.out.println("Ingrese su tarea");
                        String tarea = scanner.nextLine();
                        lista.add(tarea);
                        System.out.println(lista);
                    }

                    break;
                case 5:

                    System.out.println("Ingrese un número en grados F para comvertirlo a C");
                    double F = scanner.nextInt();
                    double C = (F-32)*5/9;

                    System.out.println("Su grado F: " +F+ " es: " +C+ "C");

                    break;
                case 6:

                    break;
            }
        }while(respuesta != 7);
    }
}
