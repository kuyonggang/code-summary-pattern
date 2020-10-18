package org.example.pattern.observer.code0030.observer;

import com.google.common.eventbus.Subscribe;
import org.example.pattern.observer.code0030.event.UserA;
import org.example.pattern.observer.code0030.event.UserC;


public class RegNotificationObserver {
    // 外部注入
//    private NotificationService notificationService;

    /**
     * 只观察C类用户
     * 可以观察所有userC及其子类
     *
     * @param userC
     */
    @Subscribe
    public void handleRegSuccess(UserC userC) {
//        promotionService.issueNewUserExperienceCash(userId);
        System.out.println(userC+"注册成功发送促销信息。。。");
    }

    @Subscribe
    public void handleRegSuccess(long userId) {
//        promotionService.issueNewUserExperienceCash(userId);
        System.out.println(userId + "long类型注册成功发送促销信息。。。");
    }

    @Subscribe
    public void handleRegSuccess(Long userId) {
//        promotionService.issueNewUserExperienceCash(userId);
        System.out.println(userId + "Long类型注册成功发送促销信息。。。");
    }

}
