package org.example.pattern.observer.code0021;

public class RegNotificationObserver implements RegObserver {
//    private NotificationService notificationService;
    @Override
    public void handleRegSuccess(long userId) {
//        notificationService.sendInboxMessage(userId, "Welcome...");
        System.out.println("++++++++++++++++++++");
    }
}
