package org.example.pattern.observer.code0020;

/**
 * 虽然注册接口做了两件事情，注册和发放体验金，违反单一职责原则，但是，如果没有扩展和修改的需求，现在的代码实现是可以接受的。
 * 如果非得用观察者模式，就需要引入更多的类和更加复杂的代码结构，反倒是一种过度设计。
 * 相反，如果需求频繁变动，比如，用户注册成功之后，不再发放体验金，而是改为发放优惠券，并且还要给用户发送一封“欢迎注册成功”的站内信。
 * 这种情况下，我们就需要频繁地修改 register() 函数中的代码，违反开闭原则。而且，如果注册成功之后需要执行的后续操作越来越多，
 * 那 register() 函数的逻辑会变得越来越复杂，也就影响到代码的可读性和可维护性。
 * 改进方案见code0021
 */
public class UserController {
    // 依赖注入
//    private UserService userService;
    // 依赖注入
//    private PromotionService promotionService;
    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
//        long userId = userService.register(telephone, password);
//        promotionService.issueNewUserExperienceCash(userId);
//        return userId;
        return null;
    }
}
