package model;

import model.enumeration.UserType;

public class User extends BaseModel {
    private String name;
    private int age;
    private String email;
    private UserType userType;

    public User(){}
    public User(int id){
        super(id);
    }
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
