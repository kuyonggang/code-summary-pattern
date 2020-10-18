package org.example.pattern.observer.code0021;

public class RegPromotionObserver implements RegObserver{
    // 依赖注入
    //private PromotionService promotionService;

     @Override
     public void handleRegSuccess(long userId) {
//     promotionService.issueNewUserExperienceCash(userId);
         System.out.println("______________");
     }
}
