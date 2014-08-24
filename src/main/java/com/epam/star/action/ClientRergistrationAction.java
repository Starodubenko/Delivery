package com.epam.star.action;

import com.epam.star.H2dao.DaoFactory;
import com.epam.star.dao.ClientDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class ClientRergistrationAction implements Action {
    @Override
    public ActionResult execute(HttpServletRequest request) throws ActionException, SQLException {

        String[] parameters = request.getParameterValues("RegistrationFormValues");

        DaoFactory daoFactory = DaoFactory.getInstance();
        ClientDao clientDao = daoFactory.getClientDao();
        clientDao.addElement(parameters);

        return null;
    }
}
