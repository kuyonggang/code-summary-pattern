package org.example.pattern.observer.code0021;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    // 依赖注入
//    private UserService userService;
    private List regObservers = new ArrayList<>();

    // 一次性设置好，之后也不可能动态的修改
     public void setRegObservers(List observers) {
        regObservers.addAll(observers);
     }

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        // 省略userService.register()异常的try-catch代码
//        long userId = userService.register(telephone, password);
        return null;
    }
}
