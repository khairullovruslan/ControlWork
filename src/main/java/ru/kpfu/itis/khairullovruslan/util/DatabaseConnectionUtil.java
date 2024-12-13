package ru.kpfu.itis.khairullovruslan.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnectionUtil {

    private static final Logger log = LoggerFactory.getLogger(DatabaseConnectionUtil.class);

    private DatabaseConnectionUtil() {
    }

    private static Connection connection;


    public static Connection getConnection() {
        String PROD_DB_HOST = System.getenv("PROD_DB_HOST");
        String PROD_DB_PORT = System.getenv("PROD_DB_PORT");
        String PROD_DB_PASSWORD = System.getenv("PROD_DB_PASSWORD");
        String PROD_DB_NAME = System.getenv("PROD_DB_NAME");
        String PROD_DB_USERNAME = System.getenv("PROD_DB_USERNAME");
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://%s:%s/%s"
                            .formatted(PROD_DB_HOST, PROD_DB_PORT, PROD_DB_NAME),
                    PROD_DB_USERNAME,
                    PROD_DB_PASSWORD
            );
            log.info("Всех братик, иди отдохни!");


        } catch(SQLException | ClassNotFoundException e){
                log.error(System.getenv("PROD_DB_HOST"));
                log.error(System.getenv("PROD_DB_PORT"));
                log.error(System.getenv("PROD_DB_PASSWORD"));
                log.error(System.getenv("PROD_DB_NAME"));
                log.error(System.getenv("PROD_DB_USERNAME"));
                throw new RuntimeException(e);
            }

            return connection;
        }


    }