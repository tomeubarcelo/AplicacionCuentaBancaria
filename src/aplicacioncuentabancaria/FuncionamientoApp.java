/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacioncuentabancaria;

import java.util.Scanner;

/**
 *
 * @author tomeu barcelo
 */
public class FuncionamientoApp {
    Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
    
    //variables para colores a usar en consola
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    
    public byte menuOpcions() { //metodo para las opciones del menu principal
        byte opcio=0;
        do{
            try{
                Scanner op = new Scanner (System.in);
                //menú de opciones del programa
                System.out.println("\n"+ANSI_BLUE+"1."+ANSI_RESET+" Ver el número de cuenta completo (CCC - Código Cuenta Cliente). ");
                System.out.println(ANSI_BLUE+"2."+ANSI_RESET+" Ver el titular de la cuenta. ");
                System.out.println(ANSI_BLUE+"3."+ANSI_RESET+" Ver el código de la entidad. ");
                System.out.println(ANSI_BLUE+"4."+ANSI_RESET+" Ver el código de la oficina. "); 
                System.out.println(ANSI_BLUE+"5."+ANSI_RESET+" Ver el número de la cuenta (solamente el número de cuenta, sin entidad, oficina ni dígitos de control).");
                System.out.println(ANSI_BLUE+"6."+ANSI_RESET+" Ver los dígitos de control de la cuenta.");
                System.out.println(ANSI_BLUE+"7."+ANSI_RESET+" Realizar un ingreso.");
                System.out.println(ANSI_BLUE+"8."+ANSI_RESET+" Retirar efectivo.");
                System.out.println(ANSI_BLUE+"9."+ANSI_RESET+" Transferencia entre cuentas.  Se transferirá la cantidad deseada a la cuenta B.");
                System.out.println(ANSI_BLUE+"10."+ANSI_RESET+" Salir.");
                System.out.print("Introduce la opción elegida: ");
                opcio=op.nextByte();
                if (opcio < 1 || opcio > 10) {
                System.out.println("Escoger entre (1..10)!.");    
                }
            }    
            catch(Exception e){
                System.out.println("Error al leer del teclado(1..10)!.");
            } 
        }while (opcio < 1 || opcio > 10);
        return opcio;
    }
    
    
    //metodo que comprueba si un valor es numerico o no
    public static boolean isNumeric(String cadena){  
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e){	
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    //metodo para comprobar si un string solo contiene letras
    public static boolean contieneSoloLetras(String cadena) {
        //metodo para comprobar si una cadena contiene solamente letras
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            // Si no está entre a y z, ni entre A y Z, ni es un espacio
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }
}
