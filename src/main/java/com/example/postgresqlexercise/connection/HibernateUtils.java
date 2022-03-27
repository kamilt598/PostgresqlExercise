package com.example.postgresqlexercise.connection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class HibernateUtils {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public List<String> listToJsp = new ArrayList();


    public void listIndexes(String choosenColumn) {

        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            List indexList = session.createQuery("SELECT column1 FROM Index group by column1 having count(column1) >1").list();
            System.out.println(indexList.get(0).getClass().getSimpleName());
            for (int i = 0; i < indexList.size(); i++) {
                listToJsp.add(indexList.get(i).toString());
            }
            /*for (Iterator iterator = indexList.iterator(); iterator.hasNext(); ) {
                Index index = (Index) iterator.next();
                switch (choosenColumn) {
                    case "kolumna1" -> listToJsp.add(index.getColumn1());
                    case "kolumna2" -> listToJsp.add(index.getColumn2());
                    case "kolumna3" -> listToJsp.add(index.getColumn3());
                    case "kolumna4" -> listToJsp.add(index.getColumn4().toString());
                }
            }*/
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


}
