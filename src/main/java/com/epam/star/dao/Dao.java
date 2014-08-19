package com.epam.star.dao;

import com.epam.star.entity.AbstractEntity;

public interface Dao<T extends AbstractEntity>{

    public T getElement(int ID);
    public void addElement(T e);
    public T deleteElement(int ID);
    public T updateElement(int ID);
}
