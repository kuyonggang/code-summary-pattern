package org.example.pattern.observer.code0030.service;

public class UserService implements IUserService{

    @Override
    public String userReg(String userName, String password) {
        System.out.println("user reg successfully...");
        return "123456";
    }
}
