/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcialfinal;
import java.net.ServerSocket;
import java.net.Socket;
/*
  Parte A by Ana Ramirez
Modificaciones Julio 
 */
public class ServidorCuadrado {
    public static void main(String[] args) {
        int puerto = 5000;
        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado en el puerto " + puerto);
                
            while (true) {
                Socket cliente = servidor.accept();
                
                if (cliente.isClosed()) break;
                
                Thread hilo = new Thread(new ManejadorCliente(cliente));
                hilo.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
}
}
