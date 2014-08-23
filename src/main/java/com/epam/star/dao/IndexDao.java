package com.epam.star.dao;

import com.epam.star.entity.Contact;

import java.util.List;

public interface IndexDao extends Dao {
    public List<Contact> getContacts();
}
