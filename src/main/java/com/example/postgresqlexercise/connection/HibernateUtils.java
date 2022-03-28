package com.example.postgresqlexercise.connection;

import com.example.postgresqlexercise.model.Index;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HibernateUtils {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public List<String> duplicateListToJsp = new ArrayList();
    public List<String> uniqueListToJsp = new ArrayList();
    List duplicateList;
    List uniqueList;

    public void duplicateAndUniqueRecords(String choosenColumn) {

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        duplicateListToJsp.clear();
        uniqueListToJsp.clear();

        try {
            transaction = session.beginTransaction();

            switch (choosenColumn) {
                case "kolumna1": {
                    duplicateList = session.createQuery("FROM Index WHERE column1 IN " +
                            "(SELECT column1 FROM Index GROUP BY column1 " +
                            "HAVING COUNT(column1) > 1)").list();
                    uniqueList = session.createQuery("FROM Index WHERE column1 IN " +
                            "(SELECT column1 FROM Index GROUP BY column1 " +
                            "HAVING COUNT(column1) = 1)").list();
                }
                break;
                case "kolumna2": {
                    duplicateList = session.createQuery("FROM Index WHERE column2 IN " +
                            "(SELECT column2 FROM Index GROUP BY column2 " +
                            "HAVING COUNT(column2) > 1)").list();
                    uniqueList = session.createQuery("FROM Index WHERE column2 IN " +
                            "(SELECT column2 FROM Index GROUP BY column2 " +
                            "HAVING COUNT(column2) = 1)").list();
                }
                break;
                case "kolumna3": {
                    duplicateList = session.createQuery("FROM Index WHERE column3 IN " +
                            "(SELECT column3 FROM Index GROUP BY column3 " +
                            "HAVING COUNT(column3) > 1)").list();
                    uniqueList = session.createQuery("FROM Index WHERE column3 IN " +
                            "(SELECT column3 FROM Index GROUP BY column3 " +
                            "HAVING COUNT(column3) = 1)").list();
                }
                break;
                case "kolumna4": {
                    duplicateList = session.createQuery("FROM Index WHERE column4 IN " +
                            "(SELECT column4 FROM Index GROUP BY column4 " +
                            "HAVING COUNT(column4) > 1)").list();
                    uniqueList = session.createQuery("FROM Index WHERE column4 IN " +
                            "(SELECT column4 FROM Index GROUP BY column4 " +
                            "HAVING COUNT(column4) = 1)").list();
                }
                break;
            }

            for (Iterator iterator = duplicateList.iterator(); iterator.hasNext(); ) {
                Index index = (Index) iterator.next();
                duplicateListToJsp.add(index.printAllColumns());
            }
            for (Iterator iterator = uniqueList.iterator(); iterator.hasNext(); ) {
                Index index = (Index) iterator.next();
                uniqueListToJsp.add(index.printAllColumns());
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
