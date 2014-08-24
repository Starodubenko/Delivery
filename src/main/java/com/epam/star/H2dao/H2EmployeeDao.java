package com.epam.star.H2dao;

import com.epam.star.dao.EmployeeDao;
import com.epam.star.entity.AbstractEntity;
import com.epam.star.entity.Client;
import com.epam.star.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class H2EmployeeDao extends AbstractH2Dao implements EmployeeDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(H2ClientDao.class);
    private static final String ADD_CLIENT = "INSERT INTO  USERS VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_CLIENT = "DELETE FROM clients WHERE id = ?";
    private Connection conn;

    public H2EmployeeDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Employee findByCredentials(String login, String password) {
        String sql = "SELECT *" +
                " FROM USERS" +
                " inner join POSITIONS" +
                " on users.POSITION_ID = positions.id" +
                " where POSITION_ID != 11 and LOGIN = " + "'" + login + "'" + "and PASSWORD = " + "'" + password + "'";
        PreparedStatement prstm = null;
        ResultSet resultSet = null;
        try {
            prstm = conn.prepareStatement(sql);
            resultSet = prstm.executeQuery();
            if (resultSet.next())
                return getClientFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
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

    private Employee getClientFromResultSet(ResultSet resultSet) {
        Employee employee = new Employee();
        try {
            employee.setId(resultSet.getInt("id"));
            employee.setLogin(resultSet.getString("login"));
            employee.setPassword(resultSet.getString("password"));
            employee.setFirstName(resultSet.getString("firstname"));
            employee.setLastName(resultSet.getString("lastname"));
            employee.setMiddleName(resultSet.getString("middlename"));
            employee.setAddress(resultSet.getString("address"));
            employee.setTelephone(resultSet.getString("telephone"));
            employee.setMobilephone(resultSet.getString("mobilephone"));
            employee.setRole(resultSet.getString("position_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    private Client getClientFromParameterValues(String[] parameterValues) {
        Client client = new Client();
        client.setLogin(parameterValues[0]);
        client.setPassword(parameterValues[1]);
        client.setFirstName(parameterValues[2]);
        client.setLastName(parameterValues[3]);
        client.setMiddleName(parameterValues[4]);
        client.setAddress(parameterValues[5]);
        client.setTelephone(parameterValues[6]);
        client.setMobilephone(parameterValues[7]);
        return client;
    }
}
