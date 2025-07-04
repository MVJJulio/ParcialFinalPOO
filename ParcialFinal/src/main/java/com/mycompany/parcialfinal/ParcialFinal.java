/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parcialfinal;

import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author abele
 * @
 */
public class ParcialFinal {
//Escribiendo SALIR como nombre se sale
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n==== Parcial Final - Cliente/Servidor ====");
            System.out.println("1. Iniciar Servidor");
            System.out.println("2. Iniciar Cliente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ServidorCuadrado.main(null);
                    break;
                case 2:
                    ClienteCuadrado.main(null);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("⚠️ Opción no válida. Intenta otra vez.");
            }

        } while (opcion != 0);
    }
}

