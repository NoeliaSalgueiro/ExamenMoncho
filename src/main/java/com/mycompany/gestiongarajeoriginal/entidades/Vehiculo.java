/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiongarajeoriginal.entidades;

/**
 *
 * @author Lenovo
 */
public class Vehiculo {
    
    private String marca;
    private String modelo;
    private String matricula;

    /**
     * Constructor para crear un vehículo con los parámetros que le damos.
     *
     * @param marca la marca del vehículo
     * @param modelo el modelo del vehículo
     * @param matricula la matrícula del vehículo
     */
    public Vehiculo(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }

    /**
     * Obtiene la marca del vehículo.
     *
     * @return la marca del vehículo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Obtiene el modelo del vehículo.
     *
     * @return el modelo del vehículo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Obtiene la matrícula del vehículo.
     *
     * @return la matrícula del vehículo
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Devuelve una cadena con los datos del vehículo: marca, modelo y matrícula.
     *
     * @return cadena con datos vehiculo
     */
    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + 
               modelo + ", Matrícula: " + matricula;
    }
}