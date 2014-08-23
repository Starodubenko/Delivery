package com.epam.star.H2dao;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactory {
    private static DaoFactory instance = new DaoFactory();

     private final BoneCP connectionPool;

    private DaoFactory() {

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        BoneCPConfig config = new BoneCPConfig();

        config.setJdbcUrl("jdbc:h2:tcp://localhost/FPDB");
        config.setUsername("Rody");
        config.setPassword("1");
        try {
            connectionPool = new BoneCP(config);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //todo move to init() method and call this method from ContextListener
    }

    //todo create destroy() method for pool shutdowning and  call this method from ContextListener

    public static DaoFactory getInstance() {
        return instance;
    }

    public H2ClientDao getClientDao() throws SQLException {
        Connection connection = connectionPool.getConnection();
        return new H2ClientDao(connection);
    }

    public H2IndexDao getIndexDao() throws SQLException {
        Connection connection = connectionPool.getConnection();
        return new H2IndexDao(connection);
    }
}
