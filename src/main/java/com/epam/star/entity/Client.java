package com.epam.star.entity;

import java.util.ArrayList;
import java.util.List;

public class Client extends AbstractUser {
    private String mobilephone;

    public Client() {
    }

    protected Client(int id, String login, String password, String firstName, String lastName, String middleName, String address, String telephone,String mobilephone) {
        super(id, login, password, firstName, lastName, middleName, address, telephone);
        this.mobilephone = mobilephone;
    }



    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public List<String> getUserFieldsNames(){
        List<String> result = new ArrayList<>();
        result.add(String.valueOf(getId()));
        result.add(getLogin());
        result.add(getPassword());
        result.add(getFirstName());
        result.add(getLastName());
        result.add(getMiddleName());
        result.add(getAddress());
        result.add(getTelephone());
        result.add(getMobilephone());
        return result;
    }
}
