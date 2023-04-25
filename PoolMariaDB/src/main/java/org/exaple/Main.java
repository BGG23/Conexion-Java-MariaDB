package org.exaple;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean salida = false;

        while (salida == false) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Elige una opcion.");
            System.out.println("1.Selecciona toda la tabla.");
            System.out.println("2.Inserta a Juan de 25 años");
            System.out.println("3.Elimina Edgar");
            System.out.println("0.Salir");
            int eleccion = keyboard.nextInt();

            switch (eleccion) {
                case 0:
                    salida = true;
                case 1:
                    ConnectioPool.selectExample();
                    break;
                case 2:
                    ConnectioPool.insertExample();
                    break;
                case 3:
                    ConnectioPool.deleteExample();
                    break;
            }
        }
    }

}