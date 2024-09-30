package org.example.connection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DatabaseConnection {
    private SessionFactory sessionFactory;

    public DatabaseConnection() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void  connectDb() throws Exception{
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.getTransaction().commit();
            System.out.println("La conexión fue exitosa.");
        }catch (HibernateException e){
            if (transaction != null){
                transaction.rollback();
            }
            throw new Exception("Error al conectar o realizar la operación en la base de datos: " + e.getMessage(), e);
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}