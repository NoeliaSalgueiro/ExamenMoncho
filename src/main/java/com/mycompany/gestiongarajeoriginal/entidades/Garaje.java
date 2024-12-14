/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiongarajeoriginal.entidades;

/**
 *
 * @author Lenovo
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.StopWatch; // Importa StopWatch

public class Garaje {

    private Map<String, Vehiculo> garaje;

    /**
     * Constructor que inicializa el garaje como un map.
     */
    public Garaje() {
        garaje = new HashMap<>();
    }

    /**
     * Agrega un vehículo al garaje.
     * Si la marca o el modelo del vehículo están vacíos o nulos, se asignan valores predeterminados.
     * Además, valida que la matrícula tenga un formato correcto.
     *
     * @param marca la marca del vehículo
     * @param modelo el modelo del vehículo
     * @param matricula la matrícula del vehículo
     */
    public void agregarVehiculo(String marca, String modelo, String matricula) {
        StopWatch stopWatch = new StopWatch(); // Medir tiempo para agregar vehículo
        stopWatch.start();

        Scanner scanner = new Scanner(System.in);

        // Validación de la marca y modelo vacíos o nulos.
        if (marca == null || marca.trim().isEmpty()) {
            marca = "Sin marca";
        }
        if (modelo == null || modelo.trim().isEmpty()) {
            modelo = "Sin modelo";
        }
        
        // Validación de la matrícula
        while (!validarMatricula(matricula)) {
            System.out.println("Matrícula inválida. El formato debe ser: 1234ABC.");
            System.out.println("Introduzca matrícula de nuevo");
            matricula = scanner.nextLine();
        }

        // Creación del nuevo vehículo que se añade al garaje.
        Vehiculo nuevoVehiculo = new Vehiculo(marca, modelo, matricula);
        garaje.put(matricula, nuevoVehiculo);  

        System.out.println("Vehículo agregado: " + nuevoVehiculo);

        stopWatch.stop();
        System.out.println("Tiempo de ejecución de agregar vehículo: " + stopWatch.getTime() + " ms");
    }

    /**
     * Valida si la matrícula del vehículo cumple con el formato requerido (1234ABC).
     *
     * @param matricula la matrícula del vehículo
     * @return {@code true} si la matrícula es válida, {@code false} sino es válida
     */
    private boolean validarMatricula(String matricula) {
        String patronValido = "^[0-9]{4}[A-Za-z]{3}$";
        Pattern patron = Pattern.compile(patronValido);
        Matcher matcher = patron.matcher(matricula);
        return matcher.matches();
    }

    /**
     * Muestra todos los vehículos almacenados en el garaje.
     * Si el garaje está vacío, se le dice al usuario
     */
    public void mostrarVehiculos() {
        StopWatch stopWatch = new StopWatch(); // Medir tiempo para mostrar vehículos
        stopWatch.start();

        if (garaje.isEmpty()) {
            System.out.println("El garaje está vacío.");
        } else {
            System.out.println("Número de vehículos en el garaje: " + garaje.size());
            System.out.println("Lista de vehículos en el garaje:");
            for (Vehiculo vehiculo : garaje.values()) {
                System.out.println(vehiculo);
            }
        }

        stopWatch.stop();
        System.out.println("Tiempo de ejecución de mostrar vehículos: " + stopWatch.getTime() + " ms");
    }

    /**
     * Elimina un vehículo del garaje usando su matrícula.
     * Si la matrícula no está registrada, se informa al usuario
     *
     * @param matricula la matrícula del vehículo a eliminar
     */
    public void eliminarVehiculo(String matricula) {
        StopWatch stopWatch = new StopWatch(); // Medir tiempo para eliminar vehículo
        stopWatch.start();

        if (garaje.containsKey(matricula)) {
            Vehiculo vehiculo = garaje.remove(matricula);
            System.out.println("Vehículo eliminado: " + vehiculo);
        } else {
            System.out.println("Vehículo no encontrado.");
        }

        stopWatch.stop();
        System.out.println("Tiempo de ejecución de eliminar vehículo: " + stopWatch.getTime() + " ms");
    }
}
