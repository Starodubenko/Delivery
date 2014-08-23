package com.epam.star.action;

import com.epam.star.H2dao.DaoFactory;
import com.epam.star.dao.ClientDao;
import com.epam.star.entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Post
public class LoginAction implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginAction.class);

    @Override
    public String execute(HttpServletRequest request) throws SQLException {

        DaoFactory daoFactory = DaoFactory.getInstance();
        ClientDao clientDao = daoFactory.getClientDao();
        List<Client> clients = clientDao.getAllClients();

            String login = request.getParameter("authenticationLogin");
            String password = request.getParameter("authenticationPassword");

            String user = null;
            String userType = null;
            Boolean f = true;

        int i = 0;
        while (i<clients.size() && f){
            String loginFromDB = clients.get(i).getLogin();
            String passwordFromDB = clients.get(i).getPassword();
            if (login.equals(loginFromDB) && password.equals(passwordFromDB)){
                user = clients.get(i).getFirstName() + " " + clients.get(i).getLastName();
                userType = "client";
                f = false;

                HttpSession session =  request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("userType", userType);
            }
            i++;
        }

            LOGGER.debug("Name and Surname obtained in the case, if authentication is successful : {}",user);

//            request.setAttribute("user", user);
//            request.setAttribute("userType", userType);

        return "index.jsp";
    }
}
