package com.mycompany.carritodecompras;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class validacionTarjeta {
    private String numero;
    private String titular;
    private String cvv;
    private String fechaVencimiento;

    public validacionTarjeta() {
        
    }

    public validacionTarjeta(String numero, String titular, String fechaVencimiento, String cvv) {
        this.numero = numero;
        this.titular = titular;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
    }

    public void solicitarDatosCliente() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Ingrese el número de su tarjeta 16 dígitos: ");
            this.numero = scanner.nextLine();
        } while (!validarNumero());
        do {
            System.out.println("Ingrese el nombre del titular: ");
            this.titular = scanner.nextLine();
        } while (!validarTitular());
        do {
            System.out.println("Ingrese la fecha de vencimiento MM/yyyy: ");
            String fechaVencimientoStr = scanner.nextLine();
            this.fechaVencimiento = fechaVencimientoStr;
        } while (!validarFecha());

        do {
            System.out.println("Ingrese el código CVV 3 dígitos: ");
            this.cvv = scanner.nextLine();
        } while (!validarCVV());
    }

    private boolean validarNumero() {
        System.out.println("Numero incorrecto, vuelva a ingresar");
        return numero.length() == 16 && numero.matches("\\d+");
    }

    private boolean validarTitular() {
        System.out.println("El nombre no es valido, ingrese de nuevo");
        return titular.matches("[a-zA-Z\\s]+");
    }

    private boolean validarFecha() {
        System.out.println("Fecha incorrecta, la fecha solo puede ser desde 11/2023");
        Date fecha = parseFecha(fechaVencimiento);
        return fecha != null && !fecha.before(new Date());
    }

    private Date parseFecha(String fechaStr) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("MM/yyyy");
            formatoFecha.setLenient(false);
            return formatoFecha.parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Fecha no valida, ingrese de nuevo, ejemplo (12/2024)");
            return null;
        }
    }

    private boolean validarCVV() {
        try {
            int cvvValue = Integer.parseInt(cvv);
            return cvv.length() == 3 && cvvValue >= 0;
        } catch (NumberFormatException e) {
            System.out.println("El CVV debe ser un número de 3 dígitos, ingrese de nuevo");
            return false;
        }
    }

    public void realizarValidacion() {
        solicitarDatosCliente();

        if (validarNumero() && validarTitular() && validarFecha() && validarCVV()) {
            System.out.println("Tarjeta válida");
        } else {
            System.out.println("Tarjeta no válida");
        }
    }

    public static void main(String[] args) {
        validacionTarjeta validador = new validacionTarjeta();
        validador.realizarValidacion();
    }
}