package org.example.controllers;

import org.example.connection.DatabaseConnection;
import org.example.entities.Libro;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LibroDao {
    private DatabaseConnection databaseConnection;

    public LibroDao() {
        this.databaseConnection = new DatabaseConnection();
    }

    //Método para guardar datos nuevos.
    public void crearLibro(Libro libro) {
        Transaction transaction = null;
        try (Session session = databaseConnection.getSession()) {
            transaction = session.beginTransaction();
            session.save(libro);
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    //Método para obtener la libro por Id.
    public Libro obtenerLibroId(int id) {
        try(Session session = databaseConnection.getSession()) {
            return session.get(Libro.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Método para obtener todas las libros.
    public List<Libro> obtenerLibro() {
        try(Session session = databaseConnection.getSession()) {
            return session.createQuery("FROM libro", Libro.class).list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Método para actualizar una libro.
    public void actualizarLibro(Libro libro) {
        Transaction transaction = null;
        try(Session session = databaseConnection.getSession()) {
            transaction = session.beginTransaction();
            session.update(libro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    //Método para eliminar una libro.
    public void eliminarLibro(int id) {
        Transaction transaction = null;
        try (Session session = databaseConnection.getSession()){
            transaction = session.beginTransaction();
            Libro libro = session.get(Libro.class, id);
            if (libro != null) {
                session.delete(libro);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
