package com.Biblioteca.models;

public class Bibliotecario extends Persona {
    public Bibliotecario(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Bibliotecario: " + nombre + " " + apellido);
    }

    public void prestarLibro(Libro libro, Usuario usuario) {
        if (libro.isDisponible() && usuario.getPrestamosActivos() < 3) {
            libro.prestar();
            usuario.incrementarPrestamos();
            System.out.println("Libro prestado a " + usuario.nombre);
        } else {
            System.out.println("No se puede prestar el libro.");
        }
    }

    public void devolverLibro(Libro libro) {
        libro.devolver();
        System.out.println("Libro devuelto.");
    }
}
