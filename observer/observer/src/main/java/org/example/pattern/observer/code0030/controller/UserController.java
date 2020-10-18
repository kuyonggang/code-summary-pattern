package org.example.pattern.observer.code0030.controller;

import org.example.pattern.observer.code0030.service.IUserService;

import java.util.List;

public class UserController {

    private IUserService userService;
    private IEventBus eventBus;

    public UserController(IUserService userService,IEventBus eventBus){
        this.userService = userService;
        this.eventBus = eventBus;
    }

    // 注册观察者
    public void setRegObservers(List<Object> observers){
        for (Object obj : observers) {
            eventBus.register(obj);
        }
    }

    // 用户注册成功后，通知观察者
    public String register(String userName,String password){
        String userId = userService.userReg(userName, password);
//        UserA userA = new UserA1(userId,userName, password);
//        eventBus.post(userA);

//        eventBus.post(Long.parseLong(userId));
        eventBus.post(23l);
        return userId;
    }
}
