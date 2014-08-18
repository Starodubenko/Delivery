package com.epam.star.action;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface Action {
    String execute(HttpServletRequest request) throws ActionException, SQLException;
}
