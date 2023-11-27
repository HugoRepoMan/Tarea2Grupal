package com.mycompany.carritodecompras;
import java.util.Scanner;
public class Carritodecompras {

    public static void main(String[] args) {
         /*validacionTarjeta tar = new validacionTarjeta();
         tar.solicitarDatosCliente();*/
         String ticketFilePath = "ticket.csv";
        ticket tic = new ticket(1);
        tic.guardarTicketEnArchivo("tickets.csv");
        tic.borrarArchivo("tickets.csv");
    }
    }
         

