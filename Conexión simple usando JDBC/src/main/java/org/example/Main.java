package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Connection conn = DBManager.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            int opcion = 0;

            while (opcion != 3) {
                System.out.println("¿Qué desea hacer?");
                System.out.println("1. Agregar persona");
                System.out.println("2. Eliminar persona");
                System.out.println("3. Salir");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese nombre:");
                        String nombre = scanner.next();
                        System.out.println("Ingrese edad:");
                        int edad = scanner.nextInt();
                        agregarPersona(conn, nombre, edad);
                        break;
                    case 2:
                        System.out.println("Ingrese ID de la persona a eliminar:");
                        int id = scanner.nextInt();
                        eliminarPersona(conn, id);
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void agregarPersona(Connection conn, String nombre, int edad) throws SQLException {
        String sql = "INSERT INTO persona (nombre, edad) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.executeUpdate();
            System.out.println("Persona agregada correctamente");
        }
    }

    private static void eliminarPersona(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM persona WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Persona eliminada correctamente");
            } else {
                System.out.println("No se encontró persona con ID " + id);
            }
        }
    }

}

