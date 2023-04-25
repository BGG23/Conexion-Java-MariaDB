package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Connection connection = DBManager.getConnection();
        if(connection !=null){
            System.out.println("Conexion Exitosa");
        }
    }

}

