package com.example.postgresqlexercise;

import com.example.postgresqlexercise.connection.HibernateUtils;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostgresqlExerciseApplication {
    public static void main(String[] args) {
        SpringApplication.run(PostgresqlExerciseApplication.class, args);

    }

}
