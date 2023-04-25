package org.exaple;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectioPool {

    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mariadb://localhost:3306/PruebaPool");
        dataSource.setUsername("root");
        dataSource.setPassword("edgar");
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    static void selectExample() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // obtiene una conexión del pool
            conn = dataSource.getConnection();

            // SELECT
            stmt = conn.prepareStatement("SELECT * FROM ejemplo");
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                System.out.println("id: " + id + ", nombre: " + nombre + ", edad: " + edad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // cierra los recursos
            try { rs.close(); } catch (Exception e) { }
            try { stmt.close(); } catch (Exception e) { }
            try { conn.close(); } catch (Exception e) { }
        }
    }

    static void insertExample() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // obtiene una conexión del pool
            conn = dataSource.getConnection();

            // INSERT
            stmt = conn.prepareStatement("INSERT INTO ejemplo (nombre, edad) VALUES (?, ?)");
            stmt.setString(1, "Juan");
            stmt.setInt(2, 25);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // cierra los recursos
            try { stmt.close(); } catch (Exception e) { }
            try { conn.close(); } catch (Exception e) { }
        }
    }

    static void deleteExample() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // obtiene una conexión del pool
            conn = dataSource.getConnection();

            // DELETE
            stmt = conn.prepareStatement("DELETE FROM ejemplo WHERE id = ?");
            stmt.setInt(1, 1);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // cierra los recursos
            try { stmt.close(); } catch (Exception e) { }
            try { conn.close(); } catch (Exception e) { }
        }
    }

}

