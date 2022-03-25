package com.example.postgresqlexercise.connection;

import com.example.postgresqlexercise.model.Index;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class HibernateUtils {

    Configuration configuration = new Configuration().configure().addAnnotatedClass(Index.class);

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void listIndexes() {

        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            List indexes = session.createQuery("FROM Index", Index.class).list();
            for (Iterator iterator = indexes.iterator(); iterator.hasNext(); ) {
                Index index = (Index) iterator.next();
                System.out.println("1: " + index.getKolumna1());
                System.out.println("2: " + index.getKolumna2());
                System.out.println("3: " + index.getKolumna3());
                System.out.println("4: " + index.getKolumna4());
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


}
