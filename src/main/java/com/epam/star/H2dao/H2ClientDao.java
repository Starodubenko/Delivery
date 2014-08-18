package com.epam.star.H2dao;

import com.epam.star.dao.ClientDao;
import com.epam.star.entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2ClientDao extends AbstractH2Dao implements ClientDao {
    private Connection conn;
    private String query;

    public H2ClientDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Client findByName(String name) throws SQLException {
        //get connection
        //set query
        //execute
        //get ResultSet
        //get fields
        //create User by fields
        //return User
        String sql = "select * from clients where name = " + name;
        PreparedStatement prstm = conn.prepareStatement(sql);

        prstm.setInt(1,name);
        return null;
    }

    @Override
    public Client findBySurnameName(String surName) {
        return null;
    }

    @Override
    public Client findByAddress(String address) {
        return null;
    }

    @Override
    public Client findByTelephone(String telephone) {
        return null;
    }

    @Override
    public Client findByMobilephone(String telephone) {
        return null;
    }

    @Override
    public Client getElement(int ID) {
        return null;
    }

    @Override
    public Client addElement(Client e) {
        return null;
    }

    @Override
    public Client deleteElement(int ID) {
        return null;
    }

    @Override
    public Client updateElement(int ID) {
        return null;
    }
}
