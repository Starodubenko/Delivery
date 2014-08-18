package com.epam.star.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;

@Post
public class LoginAction implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginAction.class);

    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String tableName = request.getParameter("TableName");
        System.out.println(tableName);
        if (tableName != null && tableName != "") {

            try {
                Class.forName("org.h2.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/F:/Видео Epam/db/FPDB", "Rody", "1");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT LOGIN,PASSWORD,FIRSTNAME,LASTNAME FROM " + tableName);
            ResultSetMetaData resultSetMD = resultSet.getMetaData();

            String login = request.getParameter("authenticationLogin");
            String password = request.getParameter("authenticationPassword");

            String result = null;
            Boolean f = true;
            while (resultSet.next() && f == true) {

                int row = resultSet.getRow();
                    String loginFromDB = resultSet.getString("LOGIN");
                    String passwordFromDB = resultSet.getString("PASSWORD");
                    if (login.equals(loginFromDB) && password.equals(passwordFromDB)){
                        result = resultSet.getString("FIRSTNAME") + " " + resultSet.getString("LASTNAME");
                        f = false;
                    }
            }

            LOGGER.debug("Name and Surname obtained in the case, if authentication is successful : {}",result);

            request.setAttribute("user", result);
            connection.close();
        }
        return "index.jsp";
    }
}
