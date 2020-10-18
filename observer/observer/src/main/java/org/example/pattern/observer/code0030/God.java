package org.example.pattern.observer.code0030;

import org.example.pattern.observer.code0030.controller.CustomEventBus;
import org.example.pattern.observer.code0030.controller.GoogleEventBus;
import org.example.pattern.observer.code0030.controller.IEventBus;
import org.example.pattern.observer.code0030.controller.UserController;
import org.example.pattern.observer.code0030.observer.RegNotificationObserver;
import org.example.pattern.observer.code0030.observer.RegPromotionObserver;
import org.example.pattern.observer.code0030.service.IUserService;
import org.example.pattern.observer.code0030.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * 上地类
 */
public class God {

    public static void main(String[] args) {
        IUserService userService = new UserService();
//        IEventBus eventBus = new GoogleEventBus();
        IEventBus eventBus = new CustomEventBus();
        UserController userController = new UserController(userService,eventBus);
        RegNotificationObserver regNotificationObserver = new RegNotificationObserver();
        RegPromotionObserver regPromotionObserver = new RegPromotionObserver();
        List<Object> observers = new ArrayList<>(2);
        observers.add(regNotificationObserver);
        observers.add(regPromotionObserver);
        userController.setRegObservers(observers);
        userController.register("zhangsan","123456");
    }

}
