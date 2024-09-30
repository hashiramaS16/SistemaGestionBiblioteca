package org.example.controllers;

import org.example.connection.DatabaseConnection;
import org.example.entities.Prestamo;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PrestamoDao {
    private DatabaseConnection databaseConnection;

    public PrestamoDao() {
        this.databaseConnection = new DatabaseConnection();
    }

    //Método para guardar datos nuevos.
    public void crearPrestamo(Prestamo prestamo) {
        Transaction transaction = null;
        try (Session session = databaseConnection.getSession()) {
            transaction = session.beginTransaction();
            session.save(prestamo);
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    //Método para obtener la prestamo por Id.
    public Prestamo obtenerPrestamoId(int id) {
        try(Session session = databaseConnection.getSession()) {
            return session.get(Prestamo.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Método para obtener todas las prestamos.
    public List<Prestamo> obtenerPrestamo() {
        try(Session session = databaseConnection.getSession()) {
            return session.createQuery("FROM prestamo", Prestamo.class).list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Método para actualizar una prestamo.
    public void actualizarPrestamo(Prestamo prestamo) {
        Transaction transaction = null;
        try(Session session = databaseConnection.getSession()) {
            transaction = session.beginTransaction();
            session.update(prestamo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    //Método para eliminar una prestamo.
    public void eliminarPrestamo(int id) {
        Transaction transaction = null;
        try (Session session = databaseConnection.getSession()){
            transaction = session.beginTransaction();
            Prestamo prestamo = session.get(Prestamo.class, id);
            if (prestamo != null) {
                session.delete(prestamo);
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
