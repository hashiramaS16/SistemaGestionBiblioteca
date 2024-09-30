package com.Biblioteca;

import com.Biblioteca.models.Bibliotecario;
import com.Biblioteca.models.Libro;
import com.Biblioteca.models.Usuario;

public class Biblioteca {
    public static void main(String[] args) {
        // Crear instancias de Usuario y Bibliotecario
        Usuario usuario1 = new Usuario("María", "Pérez");
        Bibliotecario bibliotecario = new Bibliotecario("Carlos", "López");
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", "12345");

        // Mostrar datos
        usuario1.mostrarDatos();
        bibliotecario.mostrarDatos();

        // Simular préstamo y devolución de un libro
        bibliotecario.prestarLibro(libro1, usuario1);
        bibliotecario.devolverLibro(libro1);

        // Comprobar el número de préstamos activos del usuario
        System.out.println("Préstamos activos de " + usuario1.getNombre() + ": " + usuario1.getPrestamosActivos());
    }
}
