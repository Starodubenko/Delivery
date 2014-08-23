package com.epam.star.H2dao;

import com.epam.star.dao.IndexDao;
import com.epam.star.entity.AbstractEntity;
import com.epam.star.entity.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2IndexDao extends AbstractH2Dao implements IndexDao{
    private static final Logger LOGGER = LoggerFactory.getLogger(H2ClientDao.class);
    private static final String ADD_CLIENT = "INSERT INTO CONTACTS VALUES (?, ?, ?)";
    private static final String DELETE_CLIENT = "DELETE FROM CONTACTS WHERE id = ?";
    private Connection conn;

    public H2IndexDao(Connection conn) {
        this.conn = conn;
    }
    @Override
    public List<Contact> getContacts() {
        List<Contact> result = new ArrayList<>();

        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CONTACTS");
            ResultSetMetaData resultSetMD = resultSet.getMetaData();
            while (resultSet.next()){
                result.add(getContactFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public AbstractEntity getElement(int ID) {
        return null;
    }

    @Override
    public String addElement(String[] parameterValues) {
        return null;
    }

    @Override
    public String deleteElement(int ID) {
        return null;
    }

    @Override
    public String updateElement(int ID) {
        return null;
    }

    public Contact getContactFromResultSet(ResultSet resultSet) {
        Contact contact = new Contact();
        try {
            contact.setId(resultSet.getInt("id"));
            contact.setTelephone(resultSet.getString("telephone"));
            contact.setOwner(resultSet.getString("owner"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contact;
    }

    public Contact getContactFromParameterValues(String[] parameterValues) {
        Contact contact = new Contact();
        contact.setTelephone(parameterValues[0]);
        contact.setOwner(parameterValues[1]);
        return contact;
    }
}
