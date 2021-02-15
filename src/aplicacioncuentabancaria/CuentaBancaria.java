/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacioncuentabancaria;

import static aplicacioncuentabancaria.FuncionamientoApp.isNumeric;

/**
 *
 * @author tomeu barcelo
 */
public class CuentaBancaria {

    //atributos
    private String titular;
    private String ccc;  
    private int saldo;
    
     //variables para colores a usar en consola
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    
    // instanciamos la clase
    FuncionamientoApp solicitud = new FuncionamientoApp();
        
    //Constructor per defecte
    public CuentaBancaria () {   
    }
    
    //Mètode que valida que el titular, si no és correcte crea l'excepció
    // i si és correcte guarda en titular dins l'atribut
    public void setTitular (String titular) throws Exception {
        boolean contieneSoloLetras = FuncionamientoApp.contieneSoloLetras(titular);
        //con el metodo contieneSoloLetras(nombre) comprobaremos si solo tiene letras
        if (titular.length()>40) { //crea l'excepció
            throw new Exception ("Nombre titular demasiado largo");
        } 
        else if(!contieneSoloLetras){//si no contiene letras -> error
            throw new Exception("Solo debe contener letras");
        } 
        else { //guarda el titular dins l'atribut
            this.titular=titular;
        }
    }
    
    //Mètode que retorna el valor de l'atribut titular 
    public String getTitular () {
        return titular;
    }

    //Mètode que valida que el ccc, si no és correcte crea l'excepció
    // i si és correcte guarda el ccc dins l'atribut
    public void setCcc (String ccc) throws Exception {
        if (!validarCCC(ccc)) { //crea l'excepció
            throw new Exception ("CCC incorrecto");
        }   
        else { //guarda el ccc dins l'atribut
            this.ccc=ccc;
        }
    }
    //Mètode que retorna el valor de l'atribut ccc 
    public String getCcc () {
        return ccc;
    }
    
    public void setSaldo (int saldo) throws Exception{
        if (saldo<0) { //crea l'excepció
            throw new Exception ("El saldo debe ser positivo");
        }   
        else { //guarda el saldo dins l'atribut
            this.saldo = saldo;
        }
    }
    public int getSaldo(){
        return saldo;
    }
    
    //METODOS QUE DEVUELVEN INFORMACION PARA LOS CASOS 3,4,5 Y 6
    //muestra el cod de la entidad
    public String muestraInformacionSoloEntidad(){
        return ccc.substring(0,4);
    }
    
    //muestra el cod de la oficina
    public String muestraInformacionSoloOficina(){
        return ccc.substring(4,8);
    }
    
    //muestra solo el num de cuenta
    public String muestraInformacionSoloNumCuenta(){
        return ccc.substring(10,20);
    }
    
    //muestra el cod de los digitos de control
    public String muestraInformacionSoloDC(){
        return ccc.substring(8,10);
    }
    //metodo que realiza el ingreso y actualiza el saldo total
    public int realizaIngreso(int cantidadIngresar){
        this.saldo = this.saldo + cantidadIngresar;
        return this.saldo;
    }
    
    //metodo que realiza la retirada y actualiza el saldo total
    public int realizaRetirada(int cantidadRetirar){
        this.saldo = this.saldo - cantidadRetirar;
        return this.saldo;
    }
    
    public boolean validarCCC(String cccAValidar) throws Exception{
        //metodo en el que se comprueba y se valida el CCC completo.
        //en el siguiente enlace se explica como funciona el mecanismo
        //https://www.bankcook.com/calcular-digitos-de-control-de-cuenta-corriente-bancaria/
    
        if (cccAValidar.length() != 20) {
            throw new Exception ("CCC incorrecto. Debe haber 20 dígitos");
        }
        
        //PRIMER DIGITO DE CONTROL
        //variables de los 4 digitos de la entidad
        int entidad1=Character.getNumericValue(cccAValidar.charAt(0))*4;
        int entidad2=Character.getNumericValue(cccAValidar.charAt(1))*8;
        int entidad3=Character.getNumericValue(cccAValidar.charAt(2))*5;
        int entidad4=Character.getNumericValue(cccAValidar.charAt(3))*10;
        //variables de los 4 digitos de la oficina   
        int oficina1=Character.getNumericValue(cccAValidar.charAt(4))*9;
        int oficina2=Character.getNumericValue(cccAValidar.charAt(5))*7;
        int oficina3=Character.getNumericValue(cccAValidar.charAt(6))*3;
        int oficina4=Character.getNumericValue(cccAValidar.charAt(7))*6;

        //las anteriores variables se suman (primeros 8 digitos de entidad y oficina)
        int sumaTotalEntidadOficina=(entidad1+entidad2+entidad3+entidad4+oficina1+oficina2+oficina3+oficina4);
        //para calcular el 1er digito de control se hace el modulo de la suma anterior entre 11, y este resultado se le resta a 11
        int primerDigitoControl = 11-(sumaTotalEntidadOficina%11);
        //el numero obtenido sera el 1er digito de control
        //en el caso de que de 10 el digito sera 1 y si da 11 sera 0
        if (primerDigitoControl==10) {
            primerDigitoControl=1;
        } else if(primerDigitoControl==11){
            primerDigitoControl=0;
        }

        //SEGUNDO DIGITO DE CONTROL
        //variables de los 10 digitos del numero cuenta para obtener el 2º digito de control
        int numCuenta1=Character.getNumericValue(cccAValidar.charAt(10))*1;
        int numCuenta2=Character.getNumericValue(cccAValidar.charAt(11))*2;
        int numCuenta3=Character.getNumericValue(cccAValidar.charAt(12))*4;
        int numCuenta4=Character.getNumericValue(cccAValidar.charAt(13))*8;
        int numCuenta5=Character.getNumericValue(cccAValidar.charAt(14))*5;
        int numCuenta6=Character.getNumericValue(cccAValidar.charAt(15))*10;
        int numCuenta7=Character.getNumericValue(cccAValidar.charAt(16))*9;
        int numCuenta8=Character.getNumericValue(cccAValidar.charAt(17))*7;
        int numCuenta9=Character.getNumericValue(cccAValidar.charAt(18))*3;
        int numCuenta10=Character.getNumericValue(cccAValidar.charAt(19))*6;
        
        //sumamos estas variables de los digitos del numCuenta y sacamos el modulo entre 11
        int sumaTotalNumCuenta=(numCuenta1+numCuenta2+numCuenta3+numCuenta4+numCuenta5+numCuenta6+numCuenta7+numCuenta8+numCuenta9+numCuenta10);
        //para calcular el 2º digito de control se hace el modulo de la suma anterior entre 11, y este resultado se le resta a 11
        int segundoDigitoControl=11-(sumaTotalNumCuenta%11);
        //en el caso de que de 10 el digito sera 1 y si da 11 sera 0
        if (segundoDigitoControl==10) {
            segundoDigitoControl=1;
        } else if(segundoDigitoControl==11){
            segundoDigitoControl=0;
        }
        
        //variable string con el ccc ya corregido. En la pos 8 y 9 metemos los nuevos valores de los digitos de control
        String cccValidado = cccAValidar.substring(0, 8)+primerDigitoControl+segundoDigitoControl+cccAValidar.substring(10, 20);
        if (cccValidado.equals(cccAValidar)) { //si el ccc ya introducido por el usuario estaba bien...
            return true;
        } else { //si el ccc introducido es incorrecto enviaremos un mensaje con el ccc corregido
            throw new Exception ("No se ha podido guardar el numero de cuenta ya que no es valido"); 
        }   
    }
    
    public int compruebaIngreso(String ingreso, int saldoActual) throws Exception{
    //metodo que comprueba el correcto funcionamiento de un ingreso a la cuenta A
    
        if(isNumeric(ingreso)){ //en el caso de que el metodo isNumeric sea verdadero (es decir, que sea un numero) 
            int cantidadIngresoInt = Integer.parseInt(ingreso);
            if (cantidadIngresoInt>0) {//si el ingreso es positivo se ejecuta la operacion           
                    saldoActual = saldoActual + cantidadIngresoInt;
                    return saldoActual; 
            } else{ //si el ingreso es negativo no se ejecuta la operacion
                throw new Exception("El ingreso debe ser superior a 0.");
            }
        } else{ //en el caso contrario se mostrara el mensaje de error
            throw new Exception("Debe ingresar una cantidad de dinero. Use solo dígitos");
        }           
    }
    
    public int compruebaRetirada(String retirada, int saldoActual) throws Exception{
    //metodo que comprueba el correcto funcionamiento de la retirada de la cuenta A
    
        if(isNumeric(retirada)){ //en el caso de que el metodo isNumeric sea verdadero (es decir, que sea un numero) 
            int cantidadRetirarInt = Integer.parseInt(retirada);
            if (cantidadRetirarInt>0) {//si la retirada es positiva se ejecuta la operacion           
                if (cantidadRetirarInt<saldoActual) {//si la cantidad a retirar es menor que el saldo actual
                    saldoActual = saldoActual - cantidadRetirarInt;
                    return saldoActual; 
                } else{//si la cantidad a retirar supera el saldo actual(al que le restamos la retirada)
                    System.err.println("No puede retirar efectivo mayor que su saldo actual.");
                    throw new Exception("No puede retirar efectivo mayor que su saldo actual."); 
                }
            } else{ //si el ingreso es negativo no se ejecuta la operacion
                throw new Exception("La retirada debe ser superior a 0.");
            }
        } else{ //en el caso contrario se mostrara el mensaje de error
            throw new Exception("Debe ingresar una cantidad de dinero. Use solo dígitos");
        }           
    }
}
