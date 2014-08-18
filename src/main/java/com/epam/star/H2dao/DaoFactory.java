package com.epam.star.H2dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactory {
    private static DaoFactory instance = new DaoFactory();

    private static Connection conn;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() throws SQLException {
        HikariConfig config = new HikariConfig("hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);

        ds.getConnection();
        return instance;
    }

    public H2ClientDao getClientDao() throws SQLException {
        return new H2ClientDao((Connection) getInstance());
    }
}
