package com.mycompany.carritodecompras;

import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.*;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;


public class ticket {
    private int numTurno;

    public ticket(int numTurno) {
        this.numTurno = numTurno;
    }
    
    private int generarNorden(){
       int Norden = (int)(Math.random()*100);  
        return Norden;
        
    }
     public void guardarTicketEnArchivo(String Ticket) {
        try (FileWriter fileWriter = new FileWriter(Ticket, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            int ticketGenerado = generarNorden();
            bufferedWriter.write("|--------------------------|");
            bufferedWriter.newLine();
            bufferedWriter.write("|   HUGOS ALEGRIA BAKERY   |");
            bufferedWriter.newLine();
            bufferedWriter.write("|     TICKET DE RETIRO     |");
            bufferedWriter.newLine();
            bufferedWriter.write("| Nro. de orden: " + ticketGenerado +"        |" );
            bufferedWriter.newLine();
             bufferedWriter.write("|  Gracias por preferirnos |");
            bufferedWriter.newLine();
             bufferedWriter.write("|--------------------------|");
            bufferedWriter.newLine();
            System.out.println("Ticket de orden generado");
        } catch (IOException e) {
            System.err.println("Error al generar el ticket" + e.getMessage());
        }
        try { 
            FileReader archivo = new FileReader("tickets.csv");
            if(archivo.ready()){
                BufferedReader lector = new BufferedReader(archivo);
                String cadena;
                while((cadena = lector.readLine()) != null){
                System.out.println(cadena);
            }
            }else{
                System.out.println("El archivo no puede ser leido..");
            }
        }catch(Exception e){
            System.out.println("Error"+ e.getMessage());
        }
        
    }
     
      public void borrarArchivo(String Ticket) {
        String res;
        boolean res2;
        File archivo = new File(Ticket);
        Scanner scanner = new Scanner(System.in);
         do {
            System.out.println("Desea cancelar su orden y eliminar su ticket escriba S (Si) o N (No)");
            res = scanner.nextLine().trim().toUpperCase();
            res2 = res.equals("S") || res.equals("N");
            if (!res2) {
                System.out.println("Respuesta inválida. Por favor, ingrese S o N.");
            }
        } while (!res2);
        if (res.equals("S")) {
            if (archivo.delete()) {
                System.out.println("Ticket borrado y orden cancelada, el dinero sera reembolsado");
            } else {
                System.err.println("No se pudo borrar el archivo.");
            }
        } else {
            System.out.println("Imprimiendo Ticket");
            System.out.println("Por favor acerquese a caja y espere su turno para retirar su pedido");
            System.out.println("Gracias por preferirnos :D");
        }
    }
}

