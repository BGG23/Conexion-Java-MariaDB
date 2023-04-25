package org.example.TarjetasCredito;

import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        
        int contador = 0;
        while(contador == 0){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("");
            System.out.println("Elige pibe");
            int number = keyboard.nextInt();
            switch(number){
                case 0:
                    contador = contador + 1;
                    break;
                case 1:
                    Cuenta.CrearCuenta();
                    break;
                case 2:
                    Cuenta.MostrarCuentas();
                    break;
                case 3:
                    Cuenta.Ingresar();
                    break; 
                case 4:
                    Cuenta.Retirar();
                    break;
                case 5:
                    Cuenta.BorrarCuenta();
                    break;
                case 6:
                    Cuenta.Transferencia();
                    break;
            }
        }

        
        

    }
}
