
package com.mycompany.gestiongarajeoriginal;

import com.mycompany.gestiongarajeoriginal.entidades.Garaje;
import java.util.Scanner;

/**
 * Clase principal que gestiona el acceso al garaje mediante un menú.
 * Permite agregar vehículos, mostrar los vehículos almacenados y eliminarlos del garaje.
 * Se muestra por consola.
 */
public class GestionGarajeOriginal {

    /**
     * Método principal que ejecuta el programa. Muestra un menú 
     * para realizar operaciones sobre el garaje: agregar, mostrar,
     * eliminar vehículos y salir.
     * 
     * @param args los argumentos de la línea de comandos. En este caso no se usan.
     */
    public static void main(String[] args) {
        // Se crea una instancia de la clase Garaje
        Garaje garaje = new Garaje();
        // Se inicializa un escáner para leer entradas desde el teclado
        Scanner scanner = new Scanner(System.in);

        // Bucle principal que mantiene el programa en ejecución hasta que se decida salir
        while (true) {
            // Muestra el menú de opciones al usuario
            System.out.println("\nMenu:");
            System.out.println("1. Agregar vehículo al garaje");
            System.out.println("2. Mostrar vehículos en el garaje");
            System.out.println("3. Eliminar vehículo del garaje");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = 0; // Variable para almacenar la opción seleccionada
            boolean opcionValida = false; // Bandera para validar que la opción ingresada sea correcta

            // Bucle para asegurarse que la opción ingresada sea válida (número entre 1 y 4)
            while (!opcionValida) {
                try {
                    // Intenta leer la opción del usuario
                    opcion = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer de entrada
                    // Verifica que la opción esté en el rango válido
                    if (opcion < 1 || opcion > 4) {
                        System.out.println("Opción no válida. Intente de nuevo.");
                    } else {
                        opcionValida = true; // Si la opción es válida, salir del bucle
                    }
                } catch (Exception e) {
                    // Si se ingresa un valor no numérico, muestra un mensaje de error
                    System.out.println("Introduzca un número entre 1 y 4.");
                    scanner.nextLine(); // Limpiar el buffer de entrada
                }
            }

            // Ejecuta una acción dependiendo de la opción seleccionada
            switch (opcion) {
                case 1: // Agregar un vehículo al garaje
                    System.out.print("Ingrese la marca del vehículo: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese el modelo del vehículo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese la matrícula del vehículo: ");
                    String matricula = scanner.nextLine();
                    // Llama al método para agregar el vehículo al garaje
                    garaje.agregarVehiculo(marca, modelo, matricula);
                    break;
                case 2: // Mostrar todos los vehículos en el garaje
                    // Llama al método para mostrar los vehículos
                    garaje.mostrarVehiculos();
                    break;
                case 3: // Eliminar un vehículo del garaje
                    System.out.print("Ingrese la matrícula del vehículo a eliminar: ");
                    String matriculaEliminar = scanner.nextLine();
                    // Llama al método para eliminar el vehículo por matrícula
                    garaje.eliminarVehiculo(matriculaEliminar);
                    break;
                case 4: // Salir del programa
                    System.out.println("Saliendo del programa.");
                    System.exit(0); // Finaliza la ejecución del programa
                default: // Si la opción no es válida 
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}