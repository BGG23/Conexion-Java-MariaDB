package TarjetasCredito;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Cuenta {
    public String titular;
    public float cantidad;

    public static ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();

    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banco", "edgar", "DonCanuto02");
    String insert = "INSERT INTO Cuentas (titular, cantidad) VALUES (?, ?)";


    static void CrearCuenta(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nombre del titular de la cuenta:");
        String name = keyboard.nextLine();
        

        System.out.println("Cuanto dinero tienes?");
        Float amount = keyboard.nextFloat();
        
        Cuenta cuenta = new Cuenta(name, amount);

        cuentas.add(cuenta);

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setInt(2, amount);

        pstmt.close();
        conn.close();

        
    }

    static void MostrarCuentas(){
            for(int i = 0; i<cuentas.size(); i++){
                System.out.println("Titular: " + cuentas.get(i).getTitular() + " " + "Dinero: " + cuentas.get(i).getCantidad());
            }
        
    }


    static void Ingresar(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Titular de la cuenta.");
        String nombre = keyboard.nextLine();

        for(Cuenta c : cuentas){
            if(c.getTitular().equals(nombre)){
                System.out.println("Cantidad de dinero a ingresar");
                Float ingreso = keyboard.nextFloat();
                Float dinero = c.getCantidad();
                c.setCantidad(dinero+ingreso);
                System.out.println("Has ingresado" + " " + ingreso);
            }
        }
    }

    static void Retirar(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Titular de la cuenta.");
        String nombre = keyboard.nextLine();

        for(Cuenta c : cuentas){
            if(c.getTitular().equals(nombre)){
                System.out.println("Cantidad de dinero a retirar");
                Float retiro = keyboard.nextFloat();
                Float dinero = c.getCantidad();
                c.setCantidad(dinero-retiro);
                System.out.println("Has retirado" + " " + retiro);
            }
        }
    }

    static void BorrarCuenta(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Titular de la cuenta.");
        String nombre = keyboard.nextLine();

        Object cuentaEliminar = null;

        for(Cuenta c : cuentas){
            if(c.getTitular().equals(nombre)){
                cuentaEliminar = c;
            }
        }
        cuentas.remove(cuentaEliminar);
    }

    static void Transferencia(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Titular de la cuenta que envia el dinero.");
        String emisor = keyboard.nextLine();
        System.out.println("Titular de la cuenta que recibe el dinero.");
        String receptor = keyboard.nextLine();
        Float transferencia = null;

        for(Cuenta c : cuentas){
            if(c.getTitular().equals(emisor)){
                System.out.println("Cantidad de dinero a enviar");
                transferencia = keyboard.nextFloat();
                Float dinero = c.getCantidad();
                c.setCantidad(dinero-transferencia);
            }
        }
        for(Cuenta c : cuentas){
            if(c.getTitular().equals(receptor)){
                Float dinero = c.getCantidad();
                c.setCantidad(dinero+transferencia);
            }
        }
    }

    //Getters and setters


    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public float getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }



    //Constructor


    public Cuenta(String titular, float cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }


    @Override
    public String toString() {
        return getTitular() +
               getCantidad();
    }

}
