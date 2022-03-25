package com.example.postgresqlexercise;

import com.example.postgresqlexercise.connection.HibernateUtils;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostgresqlExerciseApplication {
    private static SessionFactory factory;
    public static void main(String[] args) {
        SpringApplication.run(PostgresqlExerciseApplication.class, args);

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        HibernateUtils hibernateUtils = new HibernateUtils();
        hibernateUtils.listIndexes();
    }

}
