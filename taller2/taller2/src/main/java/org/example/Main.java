package org.example;

import org.example.connection.DatabaseConnection;
import org.example.controllers.LibroDao;
import org.example.controllers.PersonaDao;
import org.example.controllers.PrestamoDao;
import org.example.controllers.UsuarioDao;
import org.example.data.Data;
import org.example.entities.Libro;
import org.example.entities.Persona;
import org.example.entities.Prestamo;
import org.example.entities.Usuario;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        DatabaseConnection dbconnect = new DatabaseConnection();
        dbconnect.connectDb();
        Data addData = new Data();
        addData.enterData();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos para crear la persona:");
        Persona persona = new Persona();

        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine();
        persona.setNombre(nombre);

        System.out.println("Ingrese el apellido:");
        String apellido = scanner.nextLine();
        persona.setApellido(apellido);

        System.out.println("Ingrese el sexo:");
        String sexo = scanner.nextLine();
        persona.setSexo(sexo);

        // Crear instancia del DAO y guardar la persona
        PersonaDao personaDao = new PersonaDao();
        personaDao.crearPersona(persona); // Método para guardar la persona en la base de datos.

        System.out.println("Persona guardada exitosamente.");

        /////////////////////////////////////////////

        System.out.println("Ingrese los datos para crear el usuario:");
        Usuario usuario = new Usuario();

        System.out.println("Ingrese el rol:");
        String rol = scanner.nextLine();
        usuario.setRol(rol);

        // Asignar la persona creada al usuario
        usuario.setIdPersona(persona);

        // Crear instancia del DAO y guardar el usuario
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.crearUsuario(usuario); // Método para guardar el usuario en la base de datos.

        System.out.println("Usuario creado exitosamente.");

        /////////////////////////////////////////////

        System.out.println("Ingrese los datos para crear el libro:");
        Libro libro = new Libro();

        System.out.println("Ingrese el título:");
        String titulo = scanner.nextLine();
        libro.setTitulo(titulo);

        System.out.println("Ingrese el autor del libro:");
        String autor = scanner.nextLine();
        libro.setAutor(autor);

        System.out.println("Ingrese el isbn del libro:");
        String isbn = scanner.nextLine();
        libro.setIsbn(isbn);

        // Crear instancia del DAO y guardar el libro
        LibroDao libroDao = new LibroDao();
        libroDao.crearLibro(libro); // Método para guardar el libro en la base de datos.

        System.out.println("Libro creado exitosamente.");

        /////////////////////////////////////////////

        System.out.println("Ingrese los datos para el préstamo:");
        Prestamo prestamo = new Prestamo();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Fecha del préstamo:");
        String fechaPrestamo = scanner.nextLine();
        prestamo.setFechaPrestamo(dateFormat.parse(fechaPrestamo));

        System.out.println("Ingrese la fecha de devolución:");
        String devolucion = scanner.nextLine();
        prestamo.setFechaDevolucion(dateFormat.parse(devolucion));

        prestamo.setIdUsuario(usuario);

        prestamo.setIdLibro(libro);

        // Crear instancia del DAO y guardar el libro
        PrestamoDao prestamoDao = new PrestamoDao();
        prestamoDao.crearPrestamo(prestamo); // Método para guardar el libro en la base de datos.

        System.out.println("Préstamo realizado exitosamente.");
    }
}
