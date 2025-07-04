/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcialfinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author natyl
 */
public class ClienteCuadrado {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 5000;

        try (
            Socket socket = new Socket(host, puerto);
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner sc = new Scanner(System.in);
        ) {
            System.out.print("Ingrese su nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese un numero entero: ");
            int numero = sc.nextInt();

            salida.println(nombre);
            salida.println(numero);

            System.out.println("\nRespuesta del servidor:");
            System.out.println(entrada.readLine());
            System.out.println(entrada.readLine());
            System.out.println(entrada.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


