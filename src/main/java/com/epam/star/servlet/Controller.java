package com.epam.star.servlet;

import com.epam.star.action.Action;
import com.epam.star.action.ActionException;
import com.epam.star.action.ActionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Controller extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String actionName = req.getMethod() + "/" + req.getParameter("actionName");
        String actionNamee = req.getMethod() + req.getPathInfo();
        LOGGER.debug("Action name which was obtained in Controller: {}", actionName);

        Action action = ActionFactory.getAction(actionNamee);
        String reuslt = null;
        try {
            reuslt = action.execute(req);
        } catch (ActionException e) {
            LOGGER.info("Exception cached during executing of action {}", e);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (actionResult.isRedirect()) {
            resp.sendRedirect(actionResult.getView()); //redirect goes to some action (/do/welcome or something like that)
            return;
        }
        //forward goes to some page (welcome.jsp index.jsp etc) so you need to add "/WEB-INF/" "jsp" here or in every action
        req.getRequestDispatcher(actionResult.getView()).forward(req, resp); //todo use Redirect or Forward, but not forward only!!!bk
    }
}
