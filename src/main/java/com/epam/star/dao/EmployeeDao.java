package com.epam.star.dao;

import com.epam.star.entity.Employee;

public interface EmployeeDao extends Dao {
    public Employee findByCredentials(String login, String password);
}
