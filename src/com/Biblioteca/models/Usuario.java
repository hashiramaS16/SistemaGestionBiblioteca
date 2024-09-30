package com.Biblioteca.models;

public class Usuario extends Persona {
    private int prestamosActivos;

    public Usuario(String nombre, String apellido) {
        super(nombre, apellido);
        this.prestamosActivos = 0;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Usuario: " + nombre + " " + apellido);
    }

    public int getPrestamosActivos() {
        return prestamosActivos;
    }

    public void incrementarPrestamos() {
        prestamosActivos++;
    }

    public void decrementarPrestamos() {
        if (prestamosActivos > 0) {
            prestamosActivos--;
        }
    }
}
