package com.epam.star.action;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class ShowPageAction implements Action{
    private String actionResult;

    public ShowPageAction(String PageName) {
        this.actionResult = PageName;
    }

    @Override
    public String execute(HttpServletRequest request) throws ActionException, SQLException {
        return actionResult;
    }
}
