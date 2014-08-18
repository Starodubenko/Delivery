package com.epam.star.entity;

public class ClientBuilder extends AbstractUser {
    protected ClientBuilder(int id) {
        super(id);
    }

    protected ClientBuilder(int id, String login, String password, String firstName,
                            String lastName, String middleName, String address, String telephone) {
        super(id, login, password, firstName, lastName, middleName, address, telephone);
    }

    public void setId(int id){
        this.setId(id);
        return this;
    }
    public ClientBuilder setlogin(String login){
        this.setlogin(login);
        return this;
    }
    public ClientBuilder setpassword(String password){
        this.setlogin(password);
        return this;
    }
    public ClientBuilder setfirstName(String firstName){
        this.setfirstName(firstName);
        return this;
    }
    public ClientBuilder setlastName(String lastName){
        this.setfirstName(lastName);
        return this;
    }
    public ClientBuilder setmiddleName(String middleName){
        this.setfirstName(middleName);
        return this;
    }
    public ClientBuilder setaddress(String address){
        this.setfirstName(address);
        return this;
    }
    public ClientBuilder settelephone(String telephone){
        this.setfirstName(telephone);
        return this;
    }
    public Client createCliet (){
        Client client = new Client(this.getId(),this.getLogin(),this.getPassword(),
                this.getFirstName(),this.getLastName(),this.getMiddleName(),this.getAddress(),this.getTelephone());
        return client;
    }
}
