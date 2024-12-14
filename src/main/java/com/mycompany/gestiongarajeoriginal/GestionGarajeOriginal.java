
package com.mycompany.gestiongarajeoriginal;

import java.util.ArrayList;
import java.util.Scanner;

class Vehiculo {

    private String marca;
    private String modelo;
    private String matricula;

    public Vehiculo(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Matrícula: " + matricula;
    }
}

public class GestionGarajeOriginal {

    private ArrayList<Vehiculo> garaje;

    public GestionGarajeOriginal() {
        garaje = new ArrayList<>();
    }

    public void agregarVehiculo(String marca, String modelo, String matricula) {
        Vehiculo nuevoVehiculo = new Vehiculo(marca, modelo, matricula);
        garaje.add(nuevoVehiculo);
        System.out.println("Vehículo agregado: " + nuevoVehiculo);
    }

    public void mostrarVehiculos() {
        if (garaje.isEmpty()) {
            System.out.println("El garaje está vacío.");
        } else {
            System.out.println("Lista de vehículos en el garaje:");
            for (Vehiculo vehiculo : garaje) {
                System.out.println(vehiculo);
            }
        }
    }

    public void eliminarVehiculo(String matricula) {
        boolean encontrado = false;
        for (Vehiculo vehiculo : garaje) {
            if (vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
                garaje.remove(vehiculo);
                System.out.println("Vehículo eliminado: " + vehiculo);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Vehículo no encontrado.");
        }
    }

    public static void main(String[] args) {
        GestionGarajeOriginal gestionGaraje = new GestionGarajeOriginal();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nMenu:");
            System.out.println("1. Agregar vehículo al garaje");
            System.out.println("2. Mostrar vehículos en el garaje");
            System.out.println("3. Eliminar vehículo del garaje");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la marca del vehículo: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese el modelo del vehículo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese la matrícula del vehículo: ");
                    String matricula = scanner.nextLine();
                    gestionGaraje.agregarVehiculo(marca, modelo, matricula);
                    break;
                case 2:
                    gestionGaraje.mostrarVehiculos();
                    break;
                case 3:
                    System.out.print("Ingrese la matrícula del vehículo a eliminar: ");
                    String matriculaEliminar = scanner.nextLine();
                    gestionGaraje.eliminarVehiculo(matriculaEliminar);
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
