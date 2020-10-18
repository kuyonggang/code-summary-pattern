package org.example.pattern.observer.code0030.observer;

import com.google.common.eventbus.Subscribe;
import org.example.pattern.observer.code0030.event.UserA;

public class RegPromotionObserver {
    // 依赖注入
//    private PromotionService promotionService;

    /**
     * 只观察A类用户
     * 可以观察所有userA及其子类
     *
     * @param userA
     */
    @Subscribe
    public void handleRegSuccess(UserA userA) {
//        promotionService.issueNewUserExperienceCash(userId);
        System.out.println(userA + "注册成功发送促销信息。。。");
    }

    @org.example.pattern.observer.code0031.annotation.Subscribe
    public void handleRegSuccess(long userId) {
//        promotionService.issueNewUserExperienceCash(userId);
        System.out.println(userId + "long类型注册成功发送促销信息。。。");
    }

    @org.example.pattern.observer.code0031.annotation.Subscribe
    public void handleRegSuccess(Long userId) {
//        promotionService.issueNewUserExperienceCash(userId);
        System.out.println(userId + "Long类型注册成功发送促销信息。。。");
    }

}
