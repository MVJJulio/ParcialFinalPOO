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

/*
  Parte A by Ana Ramirez
 */
public class ManejadorCliente implements Runnable{
private Socket socketCliente;


        public ManejadorCliente(Socket socketCliente){
        this.socketCliente = socketCliente;
       }
   

    @Override
    public void run() {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter writer = new PrintWriter(socketCliente.getOutputStream(), true);
        ) {
            String nombreCliente = reader.readLine();
            System.out.println("Mensaje del cliente: " + nombreCliente);

            writer.println("Hola " + nombreCliente);
        } catch (IOException e) {
            System.out.println("Error con cliente: " + e.getMessage());
        } finally {
            try {
                socketCliente.close();
            } catch (IOException e) {
                System.out.println("No se pudo cerrar la conexion: " + e.getMessage());
            }
        }
    }
    }
