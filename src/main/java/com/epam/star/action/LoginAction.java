package com.epam.star.action;

import com.epam.star.H2dao.DaoFactory;
import com.epam.star.dao.ClientDao;
import com.epam.star.dao.EmployeeDao;
import com.epam.star.entity.AbstractUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Post
public class LoginAction implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginAction.class);
    private ActionResult loginn = new ActionResult("login");
    private ActionResult userr = new ActionResult("user",true);
    private ActionResult dispatcher = new ActionResult("dispatcher",true);
    private ActionResult admin = new ActionResult("admin",true);
    private ActionResult director = new ActionResult("director",true);

    @Override
    public ActionResult execute(HttpServletRequest request) throws SQLException {

        DaoFactory daoFactory = DaoFactory.getInstance();
        ClientDao clientDao = daoFactory.getClientDao();
        EmployeeDao employeeDao = daoFactory.getEmployeeDao();

        String login = request.getParameter("authenticationLogin");
        String password = request.getParameter("authenticationPassword");
        AbstractUser user = clientDao.findByCredentials(login, password);
        if (user == null)
                     user = employeeDao.findByCredentials(login,password);

        HttpSession session =  request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("userType", "user");

            LOGGER.debug("Name and Surname obtained in the case, if authentication is successful : {}",user);

        if (user == null) {
            request.setAttribute("loginError","login.incorrect.login.or.password");
            return loginn;
        }

        if (user.getRole().equalsIgnoreCase("admin"))return admin;

        if (user.getRole().equalsIgnoreCase("director"))return director;

        if (user.getRole().equalsIgnoreCase("dispatcher"))return dispatcher;

        return userr;

        /*а чо ты не используешь ActionResult? если сделать такой класс, то туда можно
        положить не только вьюху, но и доп информацию, как минимум поле редирекшн - перенаправление делать или форвард
        ну и потом, если успешно залогинился твой чувак, то нужно делать редирект на экшн отображения кабинета или чо у тя там будет
        return "welcome"; а контроллер получив это должен сделать sendRedirect на /do/welcome
        дольше писать, чем делать

         но с вытягиванием всех юзеров из базы - это конечно да....

         но сдается мне у тебя не сложилась картинка совершенно
         на счет всех этих форвардов редиректов,  да точно ) седня только начал, экзамен был готовился 3 дня
         по русскому? английскому и как? какой уровень? elementary ) мдя...
         про экшн резалт есть картинки? есть
         по сути все очень просто и примитивно

         посмотри на экшнРезалт и сделай с ним, ок? ок, я видел у кого-то экшн резалт, если что посмотрю пример
         успехов
        */

    }
}
