package ejemploJPA;

import javax.persistence.EntityTransaction;

import javax.persistence.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Usuario");
        EntityManager em = emf.createEntityManager();

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Introduce un nombre: ");
        String nombre = keyboard.nextLine();

        System.out.print("Introduce un email: ");
        String email = keyboard.nextLine();

        System.out.print("Introduce una contraseña:");
        String contraseña = keyboard.nextLine();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setContraseña(contraseña);

        em.persist(usuario);
        tx.commit();

        System.out.println("\nEl Usuario se añadió correctamente!");
    }
}
