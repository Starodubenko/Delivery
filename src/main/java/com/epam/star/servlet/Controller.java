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

public class Controller extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String actionName = req.getParameter("actionName");
        LOGGER.debug("Action name which was obtained in Controller: {}",actionName);

        Action action = ActionFactory.getAction(actionName);
        String reuslt = null;
        try {
            reuslt = action.execute(req);
        } catch (ActionException e) {
            LOGGER.info("Exception cached during executing of action {}", e);
        }
//        } catch (ClassNotFoundException e) { //todo use ActionException!!!!!!!!!!!!! and log exception and then send error
//            e.printStackTrace(); // todo but if you would use error handler servlet you could skip exception handling here because e.h. would do it
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        req.getRequestDispatcher(reuslt).forward(req,resp); //todo use Redirect or Forward, but not forward only!!!bk
    }
}
