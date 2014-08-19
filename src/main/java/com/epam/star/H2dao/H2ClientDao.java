package com.epam.star.H2dao;

import com.epam.star.dao.ClientDao;
import com.epam.star.entity.Client;
import com.epam.star.entity.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2ClientDao extends AbstractH2Dao implements ClientDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(H2ClientDao.class);
    private Connection conn;
    private String query;

    public H2ClientDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Client findByName(String name){
        String sql = "select * from clients where firstname = " + "'" + name + "'";
        PreparedStatement prstm = null;
        ResultSet resultSet = null;
        try {
            prstm = conn.prepareStatement(sql);
            resultSet = prstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getClientFromResultSet(resultSet);
    }

    @Override
    public Client findBySurnameName(String surName) {
        String sql = "select * from clients where surname = " + "'" + surName + "'";
        PreparedStatement prstm = null;
        ResultSet resultSet = null;
        try {
            prstm = conn.prepareStatement(sql);
            resultSet = prstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getClientFromResultSet(resultSet);
    }

    @Override
    public Client findByAddress(String address) {
        String sql = "select * from clients where address= " + "'" + address + "'";
        PreparedStatement prstm = null;
        ResultSet resultSet = null;
        try {
            prstm = conn.prepareStatement(sql);
            resultSet = prstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getClientFromResultSet(resultSet);
    }

    @Override
    public Client findByTelephone(String telephone) {
        String sql = "select * from clients where telephone = " + "'" + telephone + "'";
        PreparedStatement prstm = null;
        ResultSet resultSet = null;
        try {
            prstm = conn.prepareStatement(sql);
            resultSet = prstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getClientFromResultSet(resultSet);
    }

    @Override
    public Client findByMobilephone(String mobilephone) {
        String sql = "select * from clients where surname = " + "'" + mobilephone + "'";
        PreparedStatement prstm = null;
        ResultSet resultSet = null;
        try {
            prstm = conn.prepareStatement(sql);
            resultSet = prstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getClientFromResultSet(resultSet);
    }

    @Override
    public Client getElement(int ID) {
        String sql = "select * from clients where id = " + "'" + ID + "'";
        PreparedStatement prstm = null;
        ResultSet resultSet = null;
        try {
            prstm = conn.prepareStatement(sql);
            resultSet = prstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getClientFromResultSet(resultSet);
    }

    @Override
    public void addElement(Client e) {
        String sql = "select * from clients";
        PreparedStatement prstm = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMD = null;
        List<Element> namesOfColumns = new ArrayList<>();
        try {
            prstm = conn.prepareStatement(sql);
            resultSet = prstm.executeQuery();
            resultSetMD = resultSet.getMetaData();
            int i = 2;
            while(i <= resultSetMD.getColumnCount()){
                if (resultSetMD.getColumnName(i) != "ID")
                    namesOfColumns.add(new Element(resultSetMD.getColumnName(i)));
                i++;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        String valuesString = "(";
        String colsNamesString = "(";

        String[] parameters = (String[]) e.getUserFieldsNames().toArray();
        for (String parameter : parameters) {
            valuesString = valuesString + "'" + parameter + "'" +",";
        }
        valuesString = valuesString.substring(0,valuesString.length()-1) + ")";
        LOGGER.debug("String created for values of construction which insert data to database: {}",valuesString);

        for (Element nameOfColumn : namesOfColumns) {
            colsNamesString = colsNamesString + nameOfColumn.getElement() + ",";
        }
        colsNamesString = colsNamesString.substring(0,colsNamesString.length()-1) + ")";
        LOGGER.debug("String created for names of columns of table of construction which insert data to database: {}", namesOfColumns);
        try {
            prstm.execute("insert into clients" + colsNamesString + " values " + valuesString);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public Client deleteElement(int ID) {
        return null;
    }

    @Override
    public Client updateElement(int ID) {
        return null;
    }

    private Client getClientFromResultSet(ResultSet resultSet){
        Client client = new Client();
        try {
            resultSet.next();
            client.setId(resultSet.getInt("id"));
            client.setLogin(resultSet.getString("login"));
            client.setPassword(resultSet.getString("password"));
            client.setFirstName(resultSet.getString("firstname"));
            client.setLastName(resultSet.getString("lastname"));
            client.setMiddleName(resultSet.getString("middlename"));
            client.setAddress(resultSet.getString("address"));
            client.setTelephone(resultSet.getString("telephone"));
            client.setMobilephone(resultSet.getString("mobilephone"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    private Client getClientFromParameterValues(String[] parameterValues){
        Client client = new Client();
            client.setId(Integer.parseInt(parameterValues[0]));
            client.setLogin(parameterValues[1]);
            client.setPassword(parameterValues[2]);
            client.setFirstName(parameterValues[3]);
            client.setLastName(parameterValues[4]);
            client.setMiddleName(parameterValues[5]);
            client.setAddress(parameterValues[6]);
            client.setTelephone(parameterValues[7]);
            client.setMobilephone(parameterValues[8]);
        return client;
    }
}
