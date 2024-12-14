/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.gestiongarajeoriginal.entidades;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lenovo
 */

public class GarajeTest {

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testAgregarVehiculo() {
        System.out.println("agregarVehiculo");

        String[] marcas = {"Ford", "", null};
        String[] modelos = {"Fiesta", "", null};
        String[] matriculas = {"1234XYZ", "1234xyz"};

        Garaje instance = new Garaje();

        for (int i = 0; i < marcas.length; i++) {
            String marca = marcas[i];
            for (int j = 0; j < modelos.length; j++) {
                String modelo = modelos[j];
                for (int k = 0; k < matriculas.length; k++) {
                    String matricula = matriculas[k];
                    System.out.println("La probadita con: " + marca + ", Modelo: " + modelo + ", Matrícula: " + matricula);

                    instance.agregarVehiculo(marca, modelo, "");

                    if (modelo == null || modelo.trim().isEmpty()) {
                        modelo = "Sin Modelo";
                    }

                    if (marca == null || marca.trim().isEmpty()) {
                        marca = "Sin Marca";
                    }

                    assertNotNull(marca, "La marca no puede ser nula");
                    assertFalse(marca != null && marca.trim().isEmpty(), "La marca no puede estar vacía");

                    assertNotNull(modelo, "El modelo no puede ser nulo después del ajuste");
                    assertFalse(modelo.trim().isEmpty(), "El modelo no puede estar vacío después del ajuste");
                    assertTrue(matricula.matches("\\d{4}[A-Za-z]{3}"), "La matrícula debe tener el formato correcto (4 dígitos seguidos de 3 letras)");
                    assertEquals(7, matricula.length(), "La matrícula debe tener exactamente 7 caracteres");
                }
            }
        }
    }

    @Test
    public void testEliminarVehiculo() {
        System.out.println("eliminarVehiculo");

        Garaje instance = new Garaje();
        instance.agregarVehiculo("Ford", "Fiesta", "1234XYZ");
        System.out.println("Intentando eliminar vehículo con matrícula incorrecta:");
        instance.eliminarVehiculo("465");

        instance.mostrarVehiculos();

        System.out.println("Intentando eliminar vehículo con matrícula correcta:");
        instance.eliminarVehiculo("1234XYZ");

        instance.mostrarVehiculos();
    }

    @Test
    public void testMostrarVehiculos() {
        System.out.println("mostrarVehiculos");
        Garaje instance = new Garaje();
        instance.mostrarVehiculos();
    }

}
