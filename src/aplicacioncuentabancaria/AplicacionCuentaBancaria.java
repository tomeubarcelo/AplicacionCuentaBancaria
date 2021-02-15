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
 * correccio tarea 05
 */
public class AplicacionCuentaBancaria {
    /**
     * @param args the command line arguments
     */
    
    //variables para colores a usar en consola
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    
    public static void main(String[] args) throws Exception {

        // instanciamos la clase  
        FuncionamientoApp solicitud = new FuncionamientoApp();
        
        //per controlar l'entrada de dades correcte dels comptes A i B
        boolean dadaOk; 
        
        //Creació de l'objecte compteA amb el constructor per defecte
        CuentaBancaria compteA = new CuentaBancaria();
        
        //Demanam les dades de compteA
        System.out.println("CUENTA A: ");
        
        //Demanar el nom del titular del compteA fins que sigui correcte
        do { 
            try {
                dadaOk = true;
                System.out.print("Nombre del titular de la cuenta: ");
                Scanner sc = new Scanner (System.in);
                String titular = sc.next();
                compteA.setTitular(titular);  //si va bé guardarà el titular i sinó retornarà l'excepció generada
                System.out.println(compteA.getTitular()); //mostra per pantalla el titular emmagatzemat dins compteA
            }catch (Exception e){ //tractam l'excepció generada per setTitular
                System.out.println(e.getMessage()+ ". Torna a introduir el nom del titular del compte: ");
                dadaOk = false;
            }
        } while (!dadaOk);
        
        //Demanar ccc del compteA fins que sigui correcte 
        do { 
            try {
                dadaOk = true;
                System.out.print("CCC del titular: ");
                Scanner sc = new Scanner (System.in);
                String ccc = sc.next();
                compteA.setCcc(ccc);  //si va bé guardarà el titular i sinó retornarà l'excepció generada
                System.out.println(compteA.getCcc()); //mostra per pantalla el Ccc emmagatzemat dins compteA
            }catch (Exception e){ //tractam l'excepció generada per setCcc
                System.out.println(e.getMessage()+ ". Torna a introduir el CCC del titular del compte: ");
                dadaOk = false;
            }
        } while (!dadaOk);
        
        
        //COMPTE B
        //Creació de l'objecte compteA amb el constructor per defecte
        CuentaBancaria compteB = new CuentaBancaria();   
        //Demanam les dades de compteA
        System.out.println("CUENTA B: ");
        
        //Demanar titular del compteB fins que sigui correcte
        do { 
            try {
                dadaOk = true;
                System.out.print("Nombre del titular de la cuenta: ");
                Scanner sc = new Scanner (System.in);
                String titular = sc.next();
                compteB.setTitular(titular);  //si va bé guardarà el titular i sinó retornarà l'excepció generada
                System.out.println(compteB.getTitular()); //mostra per pantalla el titular emmagatzemat dins compteA
            }catch (Exception e){ //tractam l'excepció generada per setTitular
                System.out.println(e.getMessage()+ ". Vuelve a introducir el nombre del titular de la cuenta: ");
                dadaOk = false;
            }
        } while (!dadaOk);
        
        //Demanar ccc del compteB fins que sigui correcte
        do { 
            try {
                dadaOk = true;
                System.out.print("CCC del titular: ");
                Scanner sc = new Scanner (System.in);
                String ccc = sc.next();
                compteB.setCcc(ccc);  //si va bé guardarà el titular i sinó retornarà l'excepció generada
                System.out.println(compteB.getCcc()); //mostra per pantalla el Ccc emmagatzemat dins compteA
            }catch (Exception e){ //tractam l'excepció generada per setCcc
                System.out.println(e.getMessage()+ ". Vuelve a introducir el nombre del titular de la cuenta: ");
                dadaOk = false;
            }
        } while (!dadaOk);
        
        Scanner sc = new Scanner (System.in);
        //Opcions de menu
        System.out.println(ANSI_BLUE_BACKGROUND+ANSI_WHITE+"Bienvenido a nuestra aplicación. ¿Qué desea hacer?"+ANSI_RESET);
        byte opcio;
        do { 
            opcio = solicitud.menuOpcions(); //mostra les opcions de menú i retorna l'opció escollida
            switch (opcio) {
                
                case 1: //Ver el número de cuenta completo (CCC - Código Cuenta Cliente).   
                    System.out.println(compteA.getCcc());
                    break;

                case 2: //Ver el titular de la cuenta.
                    System.out.println(compteA.getTitular());
                    break;
                    
                case 3: //Ver el código de la entidad.
                    System.out.println(compteA.muestraInformacionSoloEntidad());
                    break;
                    
                case 4: //Ver el código de la oficina.
                    System.out.println(compteA.muestraInformacionSoloOficina());
                    break;
                    
                case 5: //Ver el número de la cuenta (solamente el número de cuenta, sin entidad, oficina ni dígitos de control).
                    System.out.println(compteA.muestraInformacionSoloNumCuenta());
                    break;
                    
                case 6: //Ver los dígitos de control de la cuenta.
                    System.out.println(compteA.muestraInformacionSoloDC());
                    break;
                    
                case 7: //Realizar un ingreso. Habrá que solicitar por teclado la cantidad que se desea ingresar. Siempre se mostrará el saldo final.
                    System.out.println ("¿Cuánto dinero desea ingresar?");
                    
                    String ingreso = sc.next(); //Invocamos un método sobre un objeto Scanner
                    try {
                        compteA.compruebaIngreso(ingreso, compteA.getSaldo());
                        int cantidadIngresoInt = Integer.parseInt(ingreso);
                        System.out.println("Saldo actual: "+compteA.realizaIngreso(cantidadIngresoInt)+"€.");  
                    } catch (Exception e) {
                         System.out.println(e.getMessage()+ " No se ha realizado el ingreso.");
                    }                   
                    break;
                    
                case 8: //Retirar efectivo. Una vez mostrado el saldo inicial, habrá que solicitar por teclado la cantidad que se desea retirar. Siempre se mostrará el saldo final.
                    System.out.println ("¿Cuánto dinero desea retirar?");
                    String retirada = sc.next(); //Invocamos un método sobre un objeto Scanner
                    try {
                        compteA.compruebaRetirada(retirada, compteA.getSaldo());
                        int cantidadRetiradaInt = Integer.parseInt(retirada);
                        System.out.println("Saldo actual: "+compteA.realizaRetirada(cantidadRetiradaInt)+"€.");  
                    } catch (Exception e) {
                         System.out.println(e.getMessage()+ " No se ha realizado la retirada.");
                    }        
                    break;
                    
                case 9: //Transferencia entre cuentas.  Se transferirá la cantidad deseada a la cuenta B. Siempre se mostrará el saldo final de las dos cuentas.
                    System.out.println ("¿Cuánto dinero desea transferir?");
                    String transferencia = sc.next(); //Invocamos un método sobre un objeto Scanner
                    try {
                        compteA.compruebaRetirada(transferencia, compteA.getSaldo());
                        int cantidadRetiradaInt = Integer.parseInt(transferencia);
                        System.out.println("Saldo actual cuenta A: "+compteA.realizaRetirada(cantidadRetiradaInt)+"€.");  
                        System.out.println("Saldo actual cuenta B: "+compteB.realizaIngreso(cantidadRetiradaInt)+"€."); 
                    } catch (Exception e) {
                         System.out.println(e.getMessage()+ " No se ha realizado la transferencia.");
                    }  
                    break;
                   
                case 10: //Salir de la aplicacion.
                    System.out.println(ANSI_BLUE_BACKGROUND+ANSI_WHITE+"Hasta pronto. Gracias por usar nuestra aplicación."+ANSI_RESET);
                    break;
                    
                default: 
                    System.out.println("Final de programa");
            } 
        } while (opcio==1 || opcio == 2 || opcio==3 || opcio == 4 || opcio == 5 || opcio == 6 || opcio == 7 || opcio == 8 || opcio == 9 );
    } //fin metodo main
  

}
