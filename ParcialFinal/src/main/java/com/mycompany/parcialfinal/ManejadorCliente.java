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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
  Parte A by Ana Ramirez
 */
public class ManejadorCliente implements Runnable{
   private Socket socket;
   private static boolean servidorActivo = true;
    public ManejadorCliente(Socket socket) {
        this.socket = socket;
    }

    public static boolean servidorSigueActivo() {
    return servidorActivo;
}

    public static void apagarServidor() {
    servidorActivo = false;
}

   @Override
    public void run() {
        String nombre = ""; 


        try (
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
        ) {
            nombre = entrada.readLine(); 
            
             if ("SALIR".equalsIgnoreCase(nombre)) {
                System.out.println("Solicitud de apagado recibida.");
                salida.println("El servidor se apagará...");
                apagarServidor();
                return; // salimos del hilo
            }
             
            int numero = Integer.parseInt(entrada.readLine());

            System.out.println("Cliente " + nombre + " conectado");

            int cuadrado = numero * numero;
            String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            salida.println("¡Bienvenido, " + nombre + "!");
            salida.println("El cuadrado de tu número es: " + cuadrado);
            salida.println("Fecha y hora del servidor: " + fechaHora);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Cliente " + nombre + " desconectado");
            try { socket.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    }
    }
