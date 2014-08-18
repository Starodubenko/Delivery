package com.epam.star.entity;

public class Client extends AbstractUser {
    private String mobilephone;

    protected Client(int id) {
        super(id);
    }

    protected Client(int id, String login, String password, String firstName, String lastName, String middleName, String address, String telephone) {
        super(id, login, password, firstName, lastName, middleName, address, telephone);
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }
}
